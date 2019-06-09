package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.model.Spays;
import tk.giaiphapchannuoi.server.repository.PigsRepository;
import tk.giaiphapchannuoi.server.repository.SpaysRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SpaysService {

    @Autowired
    SpaysRepository spaysRepository;

    @Autowired
    PigsRepository pigsRepository;

    @Autowired
    UsersService usersService;

    public List<Spays> findall(){
        Integer farmId = usersService.getFarmId();
        List<Spays> temp = spaysRepository.findAllByDelFlag(false);
        if (farmId.equals(0)){
            return temp;
        }
        List<Spays> spaysList = new ArrayList<>();
        for (Spays s :
                temp) {
            if (s.getPig().getHouse().getSection().getFarm().getId().equals(farmId)){
                spaysList.add(s);
            }
        }
        return spaysList;
    }

    public Optional<Spays> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<Spays> spay = spaysRepository.findByIdAndDelFlag(id,false);
        if (spay.isPresent()){
            if (farmId.equals(0) || spay.get().getPig().getHouse().getSection().getFarm().getId().equals(farmId)){
                return spay;
            }
        }
        return Optional.empty();
    }

    public Spays save(Spays spays){
        Integer farmId = usersService.getFarmId();
        Optional<Pigs> pig = pigsRepository.findByIdAndDelFlag(spays.getPig().getId(),false);
        Integer farmIdFromSpay = pig.map(p -> p.getHouse().getSection().getFarm().getId()).orElse(-1);
        if (farmId.equals(0) || farmId.equals(farmIdFromSpay)){
            spays.setDelFlag(false);
            return spaysRepository.save(spays);
        }
        return null;
    }

    public Spays update(Spays spays){
        Integer farmId = usersService.getFarmId();
        Optional<Pigs> pig = pigsRepository.findByIdAndDelFlag(spays.getPig().getId(),false);
        Integer farmIdFromSpay = pig.map(p -> p.getHouse().getSection().getFarm().getId()).orElse(-1);
        if (farmId.equals(0) || farmId.equals(farmIdFromSpay)){
            return spaysRepository.save(spays);
        }
        return null;
    }


    public Boolean delete(Spays spays){
        spays.setDelFlag(true);
        if(update(spays) != null){
            return true;
        }
        return false;
    }
}
