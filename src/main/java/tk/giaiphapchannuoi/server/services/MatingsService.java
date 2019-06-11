package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Matings;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.model.Schedule;
import tk.giaiphapchannuoi.server.model.Status;
import tk.giaiphapchannuoi.server.repository.MatingsRepository;
import tk.giaiphapchannuoi.server.repository.PigsRepository;
import tk.giaiphapchannuoi.server.repository.ScheduleRepository;
import tk.giaiphapchannuoi.server.repository.StatusRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MatingsService {

    @Autowired
    MatingsRepository matingsRepository;

    @Autowired
    PigsRepository pigsRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    PigsService pigsService;

    @Autowired
    UsersService usersService;

    public List<Matings> findall(){
        Integer farmId = usersService.getFarmId();
        List<Matings> temp = matingsRepository.findAllByDelFlag(false);
        if (farmId.equals(0)){
            return temp;
        }
        List<Matings> matingsList = new ArrayList<>();
        for (Matings m :
                temp) {
            if (m.getMother().getHouse().getSection().getFarm().getId().equals(farmId)){
                matingsList.add(m);
            }
        }
        return matingsList;
    }

    public Optional<Matings> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<Matings> mating = matingsRepository.findByIdAndDelFlag(id,false);
        if (mating.isPresent()){
            if (farmId.equals(0) || mating.get().getMother().getHouse().getSection().getFarm().getId().equals(farmId)){
                return mating;
            }
        }
        return Optional.empty();
    }

    public List<Matings> findbypig(Integer objId){// objId: mother (pig), father (pig), breed
        Integer farmId = usersService.getFarmId();
        Optional<Pigs> pig = pigsService.findbyid(objId);
        if (pig.isPresent()){
            if (farmId.equals(0) || pig.get().getHouse().getSection().getFarm().getId().equals(farmId)){
                return matingsRepository.findByMotherOrFatherIdAndDelFlag(pig.get(), objId,false);
            }
        }
        return Collections.emptyList();
//        return pig.map(p -> matingsRepository.findByMotherOrFatherIdAndDelFlag(p, objId,false)).orElse(Collections.emptyList());
    }

    @Transactional
    public Matings save(Matings mating){
        Integer farmId = usersService.getFarmId();
        Optional<Pigs> mother = pigsRepository.findByIdAndDelFlag(mating.getMother().getId(),false);
        Integer farmIdFromMating = mother.map(p -> p.getHouse().getSection().getFarm().getId()).orElse(null);

        if (farmId.equals(0) || farmId.equals(farmIdFromMating)){
            mating.setDelFlag(false);
            Schedule schedule = new Schedule();
            Matings mating_temp = matingsRepository.save(mating);
            //set schedule va luu
            schedule.setName("Đỡ đẻ cho heo \"" + mother.get().getPigCode() + "\" tại chuồng \"" + mother.get().getHouse().getName() + "\", " + mother.get().getHouse().getSection().getName() + ".");
            schedule.setDate(mating.getBirthEstimate());
            schedule.setStatus("chưa phân công");
            scheduleService.save(schedule);
            //Cap nhat status heo
            Pigs pigs = pigsRepository.findByIdAndDelFlag(mating.getMother().getId(),false).get();
            if (mating.getStatus().equals("processing")){
                Status status = statusRepository.findByCodeAndPreviousStatusAndDelFlag(11,0,false).get();
                pigs.setStatus(status);
                //Cap nhat status pig va cap nhat lai thong tin pig cho obj mating
                mating_temp.setMother(pigsService.update(pigs));
            }else if(mating.getStatus().equals("finish")){
                Status status = statusRepository.findByCodeAndPreviousStatusAndDelFlag(2, 0,false).get();
                pigs.setStatus(status);
                //Cap nhat status pig va cap nhat lai thong tin pig cho obj mating
                mating_temp.setMother(pigsService.update(pigs));
            }
            return mating_temp;
        }
        return null;
    }

    @Transactional
    public Matings update(Matings mating){
        Integer farmId = usersService.getFarmId();
        Optional<Pigs> mother = pigsRepository.findByIdAndDelFlag(mating.getMother().getId(),false);
        Integer farmIdFromMating = mother.map(p -> p.getHouse().getSection().getFarm().getId()).orElse(null);

        if (farmId.equals(0) || farmId.equals(farmIdFromMating)){
            Matings mating_temp = matingsRepository.save(mating);
            //Cap nhat status heo
            if (mating.getStatus().equals("abort")){
                Pigs pigs = pigsRepository.findByIdAndDelFlag(mating.getMother().getId(),false).get();
                Status status = statusRepository.findByCodeAndPreviousStatusAndDelFlag(4, 0,false).get();
                pigs.setStatus(status);
                //Cap nhat status pig va cap nhat lai thong tin pig cho obj mating
                mating_temp.setMother(pigsService.update(pigs));
            } else if(mating.getStatus().equals("farrow")){
                Pigs pigs = pigsRepository.findByIdAndDelFlag(mating.getMother().getId(),false).get();
                Status status = statusRepository.findByCodeAndPreviousStatusAndDelFlag(5, 0,false).get();
                pigs.setStatus(status);
                //Cap nhat status pig va cap nhat lai thong tin pig cho obj mating
                mating_temp.setMother(pigsService.update(pigs));
            }
            return mating_temp;
        }
        return null;
    }

    public Boolean delete(Matings mating){
        Integer farmId = usersService.getFarmId();
        Optional<Pigs> mother = pigsRepository.findByIdAndDelFlag(mating.getMother().getId(),false);
        Integer farmIdFromMating = mother.map(p -> p.getHouse().getSection().getFarm().getId()).orElse(null);

        if (farmId.equals(0) || farmId.equals(farmIdFromMating)){
            mating.setDelFlag(true);
            if(matingsRepository.save(mating) != null){
                return true;
            }
        }
        return false;
    }
}
