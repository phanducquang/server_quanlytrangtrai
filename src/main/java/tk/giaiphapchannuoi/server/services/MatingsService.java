package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Matings;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.model.Status;
import tk.giaiphapchannuoi.server.repository.MatingsRepository;
import tk.giaiphapchannuoi.server.repository.PigsRepository;
import tk.giaiphapchannuoi.server.repository.StatusRepository;

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
    PigsService pigsService;

    public List<Matings> findall(){
        return matingsRepository.findAllByDelFlag(false);
    }

    public Optional<Matings> findbyid(Integer id){
        return matingsRepository.findByIdAndDelFlag(id,false);
    }

    public List<Matings> findbypig(Integer objId){// objId: mother (pig), father (pig), breed
        Pigs pig = pigsService.findbyid(objId).get();
            return matingsRepository.findByMotherOrFatherIdAndDelFlag(pig, objId,false);
    }

    @Transactional
    public Matings save(Matings mating){
        mating.setDelFlag(false);
        Matings mating_temp = matingsRepository.save(mating);
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

    @Transactional
    public Matings update(Matings mating){
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

    public Boolean delete(Matings mating){
        mating.setDelFlag(true);
        if(matingsRepository.save(mating) != null){
            return true;
        }
        return false;
    }
}
