package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.FoodType;
import tk.giaiphapchannuoi.server.repository.FoodTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FoodTypeService {

    @Autowired
    FoodTypeRepository foodTypeTypeRepository;

    public List<FoodType> findall(){
        return foodTypeTypeRepository.findAllByDelFlag(false);
    }

    public Optional<FoodType> findbyid(Integer id){
        return foodTypeTypeRepository.findByIdAndDelFlag(id,false);
    }

    public FoodType save(FoodType foodType){
        return foodTypeTypeRepository.save(foodType);
    }

    public Boolean delete(FoodType foodType){
        foodType.setDelFlag(true);
        if(foodTypeTypeRepository.save(foodType) != null){
            return true;
        }
        return false;
    }
}
