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

    public List<Matings> findbypig(Integer pigId){
        Pigs pig = pigsService.findbyid(pigId).get();
        return matingsRepository.findByMotherAndDelFlag(pig,false);
    }


    @Transactional
    public Matings save(Matings mating){
        mating.setDelFlag(false);
        Matings mating_temp = matingsRepository.save(mating);
        //Cap nhat status heo
        Pigs pigs = pigsRepository.findByIdAndDelFlag(mating.getMother().getId(),false).get();
        if (mating.getStatus().equals("processing")){
            Status status = statusRepository.findByCodeAndDelFlag(11,false).get();
            pigs.setStatus(status);
            //Cap nhat status pig va cap nhat lai thong tin pig cho obj mating
            mating_temp.setMother(pigsService.update(pigs));
        }else if(mating.getStatus().equals("finish")){
            Status status = statusRepository.findByCodeAndDelFlag(2,false).get();
            pigs.setStatus(status);
            //Cap nhat status pig va cap nhat lai thong tin pig cho obj mating
            mating_temp.setMother(pigsService.update(pigs));
        }
        return mating_temp;
    }

    public Matings update(Matings mating){
        return matingsRepository.save(mating);
    }

    public Boolean delete(Matings mating){
        mating.setDelFlag(true);
        if(matingsRepository.save(mating) != null){
            return true;
        }
        return false;
    }
}
