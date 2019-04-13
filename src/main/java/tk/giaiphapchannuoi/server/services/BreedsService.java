package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Breeds;
import tk.giaiphapchannuoi.server.repository.BreedsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BreedsService {

    @Autowired
    BreedsRepository breedsRepository;

    public List<Breeds> findall(){
        return breedsRepository.findAllByDelFlag(false);
    }

    public Optional<Breeds> findbyid(Integer id){
        return breedsRepository.findByIdAndDelFlag(id,false);
    }

    public Breeds save(Breeds breeds){
        breeds.setDelFlag(false);
        return breedsRepository.save(breeds);
    }

    public Breeds update(Breeds breeds){
        return breedsRepository.save(breeds);
    }

    public Boolean delete(Breeds breeds){
        breeds.setDelFlag(true);
        if(breedsRepository.save(breeds) != null){
            return true;
        }
        return false;
    }
}
