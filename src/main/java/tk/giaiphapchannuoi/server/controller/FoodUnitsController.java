package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.FoodUnits;
import tk.giaiphapchannuoi.server.services.FoodUnitsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/foodunits")
public class FoodUnitsController {

    @Autowired
    FoodUnitsService foodUnitsService;

    @GetMapping(value = "/{id}")
    public Optional<FoodUnits> findById(@PathVariable Integer id){
        return foodUnitsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<FoodUnits> findAll(){
        return foodUnitsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody FoodUnits foodUnit){
        FoodUnits temp = foodUnitsService.save(foodUnit);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody FoodUnits foodUnit){
        FoodUnits temp = foodUnitsService.update(foodUnit);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody FoodUnits foodUnit){
        return foodUnitsService.delete(foodUnit);
    }
}
