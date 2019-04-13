package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.MarkTypes;
import tk.giaiphapchannuoi.server.repository.MarkTypesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MarkTypesService {

    @Autowired
    MarkTypesRepository markTypesRepository;

    public List<MarkTypes> findall(){
        return markTypesRepository.findAllByDelFlag(false);
    }

    public Optional<MarkTypes> findbyid(Integer id){
        return markTypesRepository.findByIdAndDelFlag(id,false);
    }

    public MarkTypes save(MarkTypes markType){
        markType.setDelFlag(false);
        return markTypesRepository.save(markType);
    }

    public MarkTypes update(MarkTypes markType){
        return markTypesRepository.save(markType);
    }


    public Boolean delete(MarkTypes markType){
        markType.setDelFlag(true);
        if(markTypesRepository.save(markType) != null){
            return true;
        }
        return false;
    }
}
