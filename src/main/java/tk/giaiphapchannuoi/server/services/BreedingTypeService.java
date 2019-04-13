package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.BreedingType;
import tk.giaiphapchannuoi.server.repository.BreedingTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BreedingTypeService {

    @Autowired
    BreedingTypeRepository breedingTypeRepository;

    public List<BreedingType> findall(){
        return breedingTypeRepository.findAllByDelFlag(false);
    }

    public Optional<BreedingType> findbyid(Integer id){
        return breedingTypeRepository.findByIdAndDelFlag(id,false);
    }

    public BreedingType save(BreedingType breedingType){
        breedingType.setDelFlag(false);
        return breedingTypeRepository.save(breedingType);
    }

    public BreedingType update(BreedingType breedingType){
        return breedingTypeRepository.save(breedingType);
    }

    public Boolean delete(BreedingType breedingType){
        breedingType.setDelFlag(true);
        if(breedingTypeRepository.save(breedingType) != null){
            return true;
        }
        return false;
    }
}
