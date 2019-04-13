package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Breedings;
import tk.giaiphapchannuoi.server.repository.BreedingsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BreedingsService {

    @Autowired
    BreedingsRepository breedingsRepository;

    public List<Breedings> findall(){
        return breedingsRepository.findAllByDelFlag(false);
    }

    public Optional<Breedings> findbyid(Integer id){
        return breedingsRepository.findByIdAndDelFlag(id,false);
    }

    public Breedings save(Breedings breedings){
        breedings.setDelFlag(false);
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
