package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Spays;
import tk.giaiphapchannuoi.server.repository.SpaysRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SpaysService {

    @Autowired
    SpaysRepository spaysRepository;

    public List<Spays> findall(){
        return spaysRepository.findAllByDelFlag(false);
    }

    public Optional<Spays> findbyid(Integer id){
        return spaysRepository.findByIdAndDelFlag(id,false);
    }

    public Spays save(Spays spays){
        spays.setDelFlag(false);
        return spaysRepository.save(spays);
    }

    public Spays update(Spays spays){
        return spaysRepository.save(spays);
    }


    public Boolean delete(Spays spays){
        spays.setDelFlag(true);
        if(spaysRepository.save(spays) != null){
            return true;
        }
        return false;
    }
}
