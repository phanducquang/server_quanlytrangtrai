package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Cages;
import tk.giaiphapchannuoi.server.repository.CagesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CagesService {

    @Autowired
    CagesRepository cagesRepository;

    public List<Cages> findall(){
        return cagesRepository.findAllByDelFlag(false);
    }

    public Optional<Cages> findbyid(Integer id){
        return cagesRepository.findByIdAndDelFlag(id,false);
    }

    public Cages save(Cages house){
        house.setDelFlag(false);
        return cagesRepository.save(house);
    }

    public Cages update(Cages house){
        return cagesRepository.save(house);
    }


    public Boolean delete(Cages house){
        house.setDelFlag(true);
        if(cagesRepository.save(house) != null){
            return true;
        }
        return false;
    }
}
