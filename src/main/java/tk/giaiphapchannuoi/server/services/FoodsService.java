package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Foods;
import tk.giaiphapchannuoi.server.repository.FoodsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FoodsService {

    @Autowired
    FoodsRepository foodsRepository;

    public List<Foods> findall(){
        return foodsRepository.findAllByDelFlag(false);
    }

    public Optional<Foods> findbyid(Integer id){
        return foodsRepository.findByIdAndDelFlag(id,false);
    }

    public Foods save(Foods food){
        return foodsRepository.save(food);
    }

    public Boolean delete(Foods food){
        food.setDelFlag(true);
        if(foodsRepository.save(food) != null){
            return true;
        }
        return false;
    }
}
