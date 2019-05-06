package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.FoodUnits;
import tk.giaiphapchannuoi.server.repository.FoodUnitsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FoodUnitsService {

    @Autowired
    FoodUnitsRepository foodUnitsRepository;

    public List<FoodUnits> findall(){
        return foodUnitsRepository.findAllByDelFlag(false);
    }

    public Optional<FoodUnits> findbyid(Integer id){
        return foodUnitsRepository.findByIdAndDelFlag(id,false);
    }

    public FoodUnits save(FoodUnits foodUnits){
        foodUnits.setDelFlag(false);
        return foodUnitsRepository.save(foodUnits);
    }

    public FoodUnits update(FoodUnits foodUnits){
        return foodUnitsRepository.save(foodUnits);
    }


    public Boolean delete(FoodUnits foodUnits){
        foodUnits.setDelFlag(true);
        if(foodUnitsRepository.save(foodUnits) != null){
            return true;
        }
        return false;
    }
}
