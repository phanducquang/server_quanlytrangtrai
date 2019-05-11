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

    public Optional<Breedings> findbyid(Integer id){
        return breedingsRepository.findByIdAndDelFlag(id,false);
    }

    @Transactional
    public Breedings save(Breedings breedings){
        breedings.setDelFlag(false);
        Pigs pig = pigsRepository.findByIdAndDelFlag(breedings.getPig().getId(),false).get();
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
            return true;
        }
        return false;
    }
}
