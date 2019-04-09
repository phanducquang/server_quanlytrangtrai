package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.FootType;
import tk.giaiphapchannuoi.server.repository.FootTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FootTypeService {

    @Autowired
    FootTypeRepository footTypeRepository;

    public List<FootType> findall(){
        return footTypeRepository.findAllByDelFlag(false);
    }

    public Optional<FootType> findbyid(Integer id){
        return footTypeRepository.findByIdAndDelFlag(id,false);
    }

    public FootType save(FootType footType){
        return footTypeRepository.save(footType);
    }

    public Boolean delete(FootType footType){
        footType.setDelFlag(true);
        if(footTypeRepository.save(footType) != null){
            return true;
        }
        return false;
    }
}
