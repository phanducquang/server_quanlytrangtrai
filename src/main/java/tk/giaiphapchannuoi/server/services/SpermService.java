package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Sperm;
import tk.giaiphapchannuoi.server.repository.SpermRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SpermService {

    @Autowired
    SpermRepository spermRepository;

    public List<Sperm> findall(){
        return spermRepository.findAllByDelFlag(false);
    }

    public Optional<Sperm> findbyid(Integer id){
        return spermRepository.findByIdAndDelFlag(id,false);
    }

    public Sperm save(Sperm sperm){
        sperm.setDelFlag(false);
        return spermRepository.save(sperm);
    }

    public Sperm update(Sperm sperm){
        return spermRepository.save(sperm);
    }

    public Boolean delete(Sperm sperm){
        sperm.setDelFlag(true);
        if(spermRepository.save(sperm) != null){
            return true;
        }
        return false;
    }
}
