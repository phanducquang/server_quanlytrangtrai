package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Breedings;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.model.Schedule;
import tk.giaiphapchannuoi.server.model.Status;
import tk.giaiphapchannuoi.server.repository.*;
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
    ScheduleRepository scheduleRepository;

    @Autowired
    UsersService usersService;

    public List<Breedings> findall(){
        List<Breedings> breedingsList = breedingsRepository.findAllByDelFlag(false);
        List<Breedings> breedingsListReturn = new ArrayList<>();

        Integer farmId = usersService.getFarmId();

        if (farmId != 0) {
            for (Breedings breeding :
                    breedingsList) {
                if (breeding.getPig().getHouse().getSection().getFarm().getId().equals(farmId)) {
                    breedingsListReturn.add(breeding);
                }
            }
            return breedingsListReturn;
        }else {
            return breedingsList;
        }
    }

    public List<Breedings> findallbypig(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<Pigs> pig = pigsRepository.findByIdAndDelFlag(id,false);
        if (pig.isPresent()){
            List<Breedings> temp = breedingsRepository.findByPigAndAndDelFlag(pig.get(),false);
            if (farmId == 0){
                return temp;
            }
            List<Breedings> breedingsList = new ArrayList<>();
            for (Breedings b :
                    temp) {
                if (b.getPig().getHouse().getSection().getFarm().getId().equals(farmId)){
                    breedingsList.add(b);
                }
            }
            return breedingsList;
        }
        return Collections.emptyList();
    }

    public Optional<Breedings> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<Breedings> breeding = breedingsRepository.findByIdAndDelFlag(id,false);
        if (breeding.isPresent()){
            if (breeding.get().getPig().getHouse().getSection().getFarm().getId().equals(farmId) || farmId == 0)
            return breeding;
        }
        return Optional.empty();
    }

    @Transactional
    public Breedings save(Breedings breedings){
        Integer farmId = usersService.getFarmId();
        Optional<Pigs> p = pigsRepository.findByIdAndDelFlag(breedings.getPig().getId(),false);
            //Lay status moi bang cach xac dinh status cua heo hien tai. Status nay la pre_status. Status can chuyen cho heo co code là 9
            //pre_status o day la code cua status goc
        if (p.isPresent()){
            if (p.get().getHouse().getSection().getFarm().getId().equals(farmId) || farmId == 0){
                breedings.setDelFlag(false);
                Schedule schedule = new Schedule();
                Schedule schedule1 = new Schedule();
                schedule.setName("Lên giống heo \"" + p.get().getPigCode() + "\" tại chuồng \"" + p.get().getHouse().getName() + "\", " + p.get().getHouse().getSection().getName() + ".");
                schedule.setDate(breedings.getBreedingNext());
                schedule.setStatus("chưa phân công");
                scheduleRepository.save(schedule);
                schedule1.setName("Phối giống heo \"" + p.get().getPigCode() + "\" tại chuồng \"" + p.get().getHouse().getName() + "\", " + p.get().getHouse().getSection().getName() + ".");
                schedule1.setDate(breedings.getMatingEstimate());
                schedule1.setStatus("chưa phân công");
                scheduleRepository.save(schedule1);
                Pigs pig = p.get();
                Status status = statusRepository.findByCodeAndPreviousStatusAndDelFlag(9,pig.getStatus().getCode(),false).get();
                pig.setStatus(status);
                Pigs temp = pigsRepository.save(pig);
                breedings.setPig(temp);
                return breedingsRepository.save(breedings);
            }
        }
        return null;
    }

    public Breedings update(Breedings breedings){
        Integer farmId = usersService.getFarmId();
        if (breedings.getPig().getHouse().getSection().getFarm().getId().equals(farmId) || farmId == 0){
            return breedingsRepository.save(breedings);
        }
        return null;
    }

    public Boolean delete(Breedings breedings){
        breedings.setDelFlag(true);
        Integer farmId = usersService.getFarmId();
        if (breedings.getPig().getHouse().getSection().getFarm().getId().equals(farmId) || farmId == 0){
            if(breedingsRepository.save(breedings) != null){
                Pigs pig = pigsRepository.findByIdAndDelFlag(breedings.getPig().getId(),false).get();
                //Lay status bang dau bang pre_status
                Status status = statusRepository.findByCodeAndDelFlag(pig.getStatus().getPreviousStatus(),false).get();
                pig.setStatus(status);
                pigsRepository.save(pig);
                return true;
            }
        }
        return false;
    }
}
