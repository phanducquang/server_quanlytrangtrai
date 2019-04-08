package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.FarmTypes;
import tk.giaiphapchannuoi.server.repository.FarmTypesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FarmTypesService {

    @Autowired
    FarmTypesRepository farmTypeTypeRepository;

    public List<FarmTypes> findall(){
        return farmTypeTypeRepository.findAllByDelFlag(false);
    }

    public Optional<FarmTypes> findbyid(Integer id){
        return farmTypeTypeRepository.findByIdAndDelFlag(id,false);
    }

    public FarmTypes save(FarmTypes farmType){
        return farmTypeTypeRepository.save(farmType);
    }

    public Boolean delete(FarmTypes farmType){
        farmType.setDelFlag(true);
        if(farmTypeTypeRepository.save(farmType) != null){
            return true;
        }
        return false;
    }
}
