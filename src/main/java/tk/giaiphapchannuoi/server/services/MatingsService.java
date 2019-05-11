package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Matings;
import tk.giaiphapchannuoi.server.repository.MatingsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MatingsService {

    @Autowired
    MatingsRepository matingsRepository;

    public List<Matings> findall(){
        return matingsRepository.findAllByDelFlag(false);
    }

    public Optional<Matings> findbyid(Integer id){
        return matingsRepository.findByIdAndDelFlag(id,false);
    }

    @Transactional
    public Matings save(Matings mating){
        mating.setDelFlag(false);
        return matingsRepository.save(mating);
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
