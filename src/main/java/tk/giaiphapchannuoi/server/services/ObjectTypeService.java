package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.ObjectType;
import tk.giaiphapchannuoi.server.repository.ObjectTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ObjectTypeService {

    @Autowired
    ObjectTypeRepository objectTypeRepository;

    public List<ObjectType> findall(){
        return objectTypeRepository.findAllByDelFlag(false);
    }

    public Optional<ObjectType> findbyid(Integer id){
        return objectTypeRepository.findByIdAndDelFlag(id,false);
    }

    public ObjectType save(ObjectType objectType){
        return objectTypeRepository.save(objectType);
    }

    public Boolean delete(ObjectType objectType){
        objectType.setDelFlag(true);
        if(objectTypeRepository.save(objectType) != null){
            return true;
        }
        return false;
    }
}
