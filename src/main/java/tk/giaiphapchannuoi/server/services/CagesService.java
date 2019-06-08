package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Cages;
import tk.giaiphapchannuoi.server.repository.CagesRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CagesService {

    @Autowired
    CagesRepository cagesRepository;

    @Autowired
    UsersService usersService;

    public List<Cages> findall(){
        Integer farmId = usersService.getFarmId();
        List<Cages> temp = cagesRepository.findAllByDelFlag(false);
        if (farmId == 0){
            return temp;
        }
        List<Cages> cagesList = new ArrayList<>();
        for (Cages c :
                temp) {
            if (c.getSection().getFarm().getId().equals(farmId)){
                cagesList.add(c);
            }
        }
        return cagesList;
    }

    public Optional<Cages> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<Cages> cage = cagesRepository.findByIdAndDelFlag(id,false);
        if (cage.isPresent()){
            if (farmId == 0 || cage.get().getSection().getFarm().getId().equals(farmId)) {
                return cage;
            }
        }
        return Optional.empty();
    }

    public Cages save(Cages cage){
        Integer farmId = usersService.getFarmId();
        if (cage.getSection().getFarm().getId().equals(farmId) || farmId == 0){
            cage.setDelFlag(false);
            return cagesRepository.save(cage);
        }
        return null;
    }

    public Cages update(Cages cage){
        Integer farmId = usersService.getFarmId();
        if (cage.getSection().getFarm().getId().equals(farmId) || farmId == 0){
            return cagesRepository.save(cage);
        }
        return null;
    }


    public Boolean delete(Cages cage){
        cage.setDelFlag(true);
        Integer farmId = usersService.getFarmId();
        if (cage.getSection().getFarm().getId().equals(farmId) || farmId == 0){
            if(cagesRepository.save(cage) != null){
                return true;
            }
        }
        return false;
    }
}
