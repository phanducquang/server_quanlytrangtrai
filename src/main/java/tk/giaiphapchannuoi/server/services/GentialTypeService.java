package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.GentialType;
import tk.giaiphapchannuoi.server.repository.GentialTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GentialTypeService {

    @Autowired
    GentialTypeRepository gentialTypeRepository;

    public List<GentialType> findall(){
        return gentialTypeRepository.findAllByDelFlag(false);
    }

    public Optional<GentialType> findbyid(Integer id){
        return gentialTypeRepository.findByIdAndDelFlag(id,false);
    }

    public GentialType save(GentialType gentialType){
        return gentialTypeRepository.save(gentialType);
    }

    public Boolean delete(GentialType gentialType){
        gentialType.setDelFlag(true);
        if(gentialTypeRepository.save(gentialType) != null){
            return true;
        }
        return false;
    }
}
