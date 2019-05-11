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

    public List<Breedings> findall(){
        return breedingsRepository.findAllByDelFlag(false);
    }

    public List<Breedings> findallbypig(Integer id){
        Pigs pig = pigsRepository.findByIdAndDelFlag(id,false).get();
        return breedingsRepository.findByPigAndAndDelFlag(pig,false);
    }

    public Optional<Breedings> findbyid(Integer id){
        return breedingsRepository.findByIdAndDelFlag(id,false);
    }

    @Transactional
    public Breedings save(Breedings breedings){
        breedings.setDelFlag(false);
        Pigs pig = pigsRepository.findByIdAndDelFlag(breedings.getPig().getId(),false).get();
        //Lay status moi bang cach xac dinh status cua heo hien tai. Status nay la pre_status. Status can chuyen cho heo co code là 9
        //pre_status o day la code cua status goc
        Status status = statusRepository.findByCodeAndPreviousStatusAndDelFlag(9,pig.getStatus().getCode(),false).get();
        pig.setStatus(status);
        pigsRepository.save(pig);
        return breedingsRepository.save(breedings);
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
