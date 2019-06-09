package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.model.Sperm;
import tk.giaiphapchannuoi.server.repository.PigsRepository;
import tk.giaiphapchannuoi.server.repository.SpermRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SpermService {

    @Autowired
    SpermRepository spermRepository;

    @Autowired
    PigsService pigsService;

    @Autowired
    UsersService usersService;

    public List<Sperm> findall(){
        Integer farmId = usersService.getFarmId();
        List<Sperm> temp = spermRepository.findAllByDelFlag(false);
        if (farmId.equals(0)){
            return temp;
        }
        List<Sperm> spermList = new ArrayList<>();
        for (Sperm s :
                temp) {
            if (s.getPig().getHouse().getSection().getFarm().getId().equals(farmId)){
                spermList.add(s);
            }
        }
        return spermList;
    }

    public Optional<Sperm> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<Sperm> sperm = spermRepository.findByIdAndDelFlag(id,false);
        if (sperm.isPresent()){
            if (farmId.equals(0) || sperm.get().getPig().getHouse().getSection().getFarm().getId().equals(farmId)){
                return sperm;
            }
        }
        return Optional.empty();
    }

    public List<Sperm> findbypig(Integer pigId){
        Integer farmId = usersService.getFarmId();
        Optional<Pigs> pig = pigsService.findbyid(pigId);
        List<Sperm> temp =  pig.map(p -> spermRepository.findByPigAndDelFlag(p,false)).orElse(Collections.emptyList());
        if (farmId.equals(0)){
            return temp;
        }
        List<Sperm> spermList = new ArrayList<>();
        for (Sperm s :
                temp) {
            if (s.getPig().getHouse().getSection().getFarm().getId().equals(farmId)){
                spermList.add(s);
            }
        }
        return spermList;
    }

    public Sperm save(Sperm sperm){
        Integer farmId = usersService.getFarmId();
        Optional<Pigs> pig = pigsService.findbyid(sperm.getPig().getId());
        Integer farmIdFromSperm = pig.map(p -> p.getHouse().getSection().getFarm().getId()).orElse(-1);
        if (farmId.equals(0) || farmId.equals(farmIdFromSperm)){
            sperm.setDelFlag(false);
            return spermRepository.save(sperm);
        }
        return null;
    }

    public Sperm update(Sperm sperm){
        Integer farmId = usersService.getFarmId();
        Optional<Pigs> pig = pigsService.findbyid(sperm.getPig().getId());
        Integer farmIdFromSperm = pig.map(p -> p.getHouse().getSection().getFarm().getId()).orElse(-1);
        if (farmId.equals(0) || farmId.equals(farmIdFromSperm)){
            return spermRepository.save(sperm);
        }
        return null;
    }

    public Boolean delete(Sperm sperm){
        sperm.setDelFlag(true);
        if(update(sperm) != null){
            return true;
        }
        return false;
    }
}
