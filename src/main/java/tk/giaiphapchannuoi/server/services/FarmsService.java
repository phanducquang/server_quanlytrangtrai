package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Farms;
import tk.giaiphapchannuoi.server.repository.FarmsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FarmsService {

    @Autowired
    FarmsRepository farmsRepository;

    @Autowired
    UsersService usersService;

    public List<Farms> findall(){
//        Integer farmId = usersService.getFarmId();
//        List<Farms> temp = farmsRepository.findAllByDelFlag(false);
//        if (farmId == 0){
//            return temp;
//        }
//        List<Farms> farmsList = new ArrayList<>();
//        for (Farms f :
//                temp) {
//            if (f.getId().equals(farmId)){
//                farmsList.add(f);
//            }
//        }
//        return farmsList;
        return farmsRepository.findAllByDelFlag(false);
    }

    public Optional<Farms> findbyid(Integer id){
//        Integer farmId = usersService.getFarmId();
//        Optional<Farms> farm = farmsRepository.findByIdAndDelFlag(id,false);
//        if (farm.isPresent()){
//            if (farm.get().getId().equals(farmId) || farmId == 0){
//                return farm;
//            }
//        }
//        return Optional.empty();
        return farmsRepository.findByIdAndDelFlag(id,false);
    }

    public Farms save(Farms farm){
        Integer farmId = usersService.getFarmId();
        if (farmId == 0) {
            farm.setDelFlag(false);
            return farmsRepository.save(farm);
        }
        return null;
    }

    public Farms update(Farms farm){
        Integer farmId = usersService.getFarmId();
        if (farm.getId().equals(farmId) || farmId == 0){
            return farmsRepository.save(farm);
        }
        return null;
    }


    public Boolean delete(Farms farm){
        Integer farmId = usersService.getFarmId();
        if (farm.getId().equals(farmId) || farmId == 0){
            farm.setDelFlag(true);
            if(farmsRepository.save(farm) != null){
                return true;
            }
        }
        return false;
    }
}
