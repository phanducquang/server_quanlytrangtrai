package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.DTO.Pigs1DTO;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.model.Weanings;
import tk.giaiphapchannuoi.server.repository.Pigs1DTORepository;
import tk.giaiphapchannuoi.server.repository.WeaningsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WeaningsService {

    @Autowired
    WeaningsRepository weaningsRepository;

    @Autowired
    Pigs1DTORepository pigs1DTORepository;

    @Autowired
    UsersService usersService;

    public List<Weanings> findall(){
        Integer farmId = usersService.getFarmId();
        if (farmId == 0){
            return weaningsRepository.findAllByDelFlag(false);
        }
        List<Weanings> temp = weaningsRepository.findAllByDelFlag(false);
        List<Weanings> warehousesList = new ArrayList<>();
        for (Weanings w :
                temp) {
            if (w.getPig().getHouse().getSection().getFarm().getId().equals(farmId)){
                warehousesList.add(w);
            }
        }
        return warehousesList;
    }

    public Optional<Weanings> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<Weanings> weaning = weaningsRepository.findByIdAndDelFlag(id,false);
        if (weaning.isPresent()){
            if (farmId.equals(0) || weaning.get().getPig().getHouse().getSection().getFarm().getId().equals(farmId)){
                return weaning;
            }
        }
        return Optional.empty();
    }

    public Weanings save(Weanings weaning){
        Integer farmId = usersService.getFarmId();
        Optional<Pigs1DTO> pig = pigs1DTORepository.findByIdAndDelFlag(weaning.getPig().getId(),false);
        Integer farmIdFromWeaning = pig.map(p -> p.getHouse().getSection().getFarm().getId()).orElse(null);
        if (farmId.equals(0) || farmId.equals(farmIdFromWeaning)){
            weaning.setDelFlag(false);
            return weaningsRepository.save(weaning);
        }
        return null;
    }

    public Weanings update(Weanings weaning){
        Integer farmId = usersService.getFarmId();
        Optional<Pigs1DTO> pig = pigs1DTORepository.findByIdAndDelFlag(weaning.getPig().getId(),false);
        Integer farmIdFromWeaning = pig.map(p -> p.getHouse().getSection().getFarm().getId()).orElse(null);
        if (farmId.equals(0) || farmId.equals(farmIdFromWeaning)){
            return weaningsRepository.save(weaning);
        }
        return null;
    }

    public Boolean delete(Weanings weaning){
        weaning.setDelFlag(true);
        if(update(weaning) != null){
            return true;
        }
        return false;
    }
}
