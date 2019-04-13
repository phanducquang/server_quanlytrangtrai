package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Rounds;
import tk.giaiphapchannuoi.server.repository.RoundsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoundsService {

    @Autowired
    RoundsRepository roundsRepository;

    public List<Rounds> findall(){
        return roundsRepository.findAllByDelFlag(false);
    }

    public Optional<Rounds> findbyid(Integer id){
        return roundsRepository.findByIdAndDelFlag(id,false);
    }

    public Rounds save(Rounds round){
        round.setDelFlag(false);
        return roundsRepository.save(round);
    }

    public Rounds update(Rounds round){
        return roundsRepository.save(round);
    }

    public Boolean delete(Rounds round){
        round.setDelFlag(true);
        if(roundsRepository.save(round) != null){
            return true;
        }
        return false;
    }
}
