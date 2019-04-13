package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Weanings;
import tk.giaiphapchannuoi.server.repository.WeaningsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WeaningsService {

    @Autowired
    WeaningsRepository weaningsRepository;

    public List<Weanings> findall(){
        return weaningsRepository.findAllByDelFlag(false);
    }

    public Optional<Weanings> findbyid(Integer id){
        return weaningsRepository.findByIdAndDelFlag(id,false);
    }

    public Weanings save(Weanings weaning){
        weaning.setDelFlag(false);
        return weaningsRepository.save(weaning);
    }

    public Weanings update(Weanings weaning){
        return weaningsRepository.save(weaning);
    }

    public Boolean delete(Weanings weaning){
        weaning.setDelFlag(true);
        if(weaningsRepository.save(weaning) != null){
            return true;
        }
        return false;
    }
}
