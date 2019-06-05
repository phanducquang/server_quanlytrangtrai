package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Breedings;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.model.Status;
import tk.giaiphapchannuoi.server.repository.BreedingsRepository;
import tk.giaiphapchannuoi.server.repository.PigsRepository;
import tk.giaiphapchannuoi.server.repository.StatusRepository;
import tk.giaiphapchannuoi.server.repository.UsersRepository;
import tk.giaiphapchannuoi.server.security.JwtAuthenticationFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BreedingsService {

    @Autowired
    BreedingsRepository breedingsRepository;

    @Autowired
    PigsRepository pigsRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    UsersRepository usersRepository;

    public List<Breedings> findall(){
        List<Breedings> breedingsList = breedingsRepository.findAllByDelFlag(false);
        List<Breedings> breedingsListReturn = new ArrayList<>();

        //Lay userId thong qua bien public từ class JwtAuthenticationFilter
        int UserId = JwtAuthenticationFilter.userIdGlobal;
        //Xac dinh farm id bang cach lay thong tin user => lay thong tin employee => lay thong tin farm
        int FarmIdFromUser = usersRepository.findByIdAndDelFlag(UserId,false).get().getEmployee().getFarm().getId();

        if (FarmIdFromUser != 0) {
            for (Breedings breeding :
                    breedingsList) {
                if (breeding.getPig().getHouse().getSection().getFarm().getId() == FarmIdFromUser) {
                    breedingsListReturn.add(breeding);
                }
            }
            return breedingsListReturn;
        }else {
            return breedingsList;
        }
    }

    public List<Breedings> findallbypig(Integer id){
        Optional<Pigs> pig = pigsRepository.findByIdAndDelFlag(id,false);
        return pig.map(p -> breedingsRepository.findByPigAndAndDelFlag(p,false)).orElse(Collections.emptyList());
    }

    public Optional<Breedings> findbyid(Integer id){
        return breedingsRepository.findByIdAndDelFlag(id,false);
    }

    @Transactional
    public Breedings save(Breedings breedings){
        breedings.setDelFlag(false);
        Optional<Pigs> p = pigsRepository.findByIdAndDelFlag(breedings.getPig().getId(),false);
        //Lay status moi bang cach xac dinh status cua heo hien tai. Status nay la pre_status. Status can chuyen cho heo co code là 9
        //pre_status o day la code cua status goc
        if (p.isPresent()){
            Pigs pig = p.get();
            Status status = statusRepository.findByCodeAndPreviousStatusAndDelFlag(9,pig.getStatus().getCode(),false).get();
            pig.setStatus(status);
            Pigs temp = pigsRepository.save(pig);
            breedings.setPig(temp);
            return breedingsRepository.save(breedings);
        }
        return null;
    }

    public Breedings update(Breedings breedings){
        return breedingsRepository.save(breedings);
    }

    public Boolean delete(Breedings breedings){
        breedings.setDelFlag(true);
        if(breedingsRepository.save(breedings) != null){
            Pigs pig = pigsRepository.findByIdAndDelFlag(breedings.getPig().getId(),false).get();
            //Lay status bang dau bang pre_status
            Status status = statusRepository.findByCodeAndDelFlag(pig.getStatus().getPreviousStatus(),false).get();
            pig.setStatus(status);
            pigsRepository.save(pig);
            return true;
        }
        return false;
    }
}
