package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Births;
import tk.giaiphapchannuoi.server.repository.BirthsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BirthsService {

    @Autowired
    BirthsRepository birthsRepository;

    public List<Births> findall(){
        return birthsRepository.findAllByDelFlag(false);
    }

    public Optional<Births> findbyid(Integer id){
        return birthsRepository.findByIdAndDelFlag(id, false);
    }

    public Births save(Births births){
        return birthsRepository.save(births);
    }

    public Boolean delete(Births births){
        births.setDelFlag(true);
        if(birthsRepository.save(births) != null){
            return true;
        }
        return false;
    }

}
