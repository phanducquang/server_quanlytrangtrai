package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.FoodType;
import tk.giaiphapchannuoi.server.services.FoodTypeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/foodtype")
public class FoodTypeController {

    @Autowired
    FoodTypeService foodTypeTypeService;

    @GetMapping(value = "/{id}")
    public Optional<FoodType> findById(@PathVariable Integer id){
        return foodTypeTypeService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<FoodType> findAll(){
        return foodTypeTypeService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody FoodType foodType){
        if(foodTypeTypeService.save(foodType) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foodType);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody FoodType foodType){
        if(foodTypeTypeService.save(foodType) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foodType);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody FoodType foodType){
        return foodTypeTypeService.delete(foodType);
    }
}
