package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Foods;
import tk.giaiphapchannuoi.server.services.FoodsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/foods")
public class FoodsController {

    @Autowired
    FoodsService foodsService;

    @GetMapping(value = "/{id}")
    public Optional<Foods> findById(@PathVariable Integer id){
        return foodsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Foods> findAll(){
        return foodsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Foods food){
        if(foodsService.save(food) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(food);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Foods food){
        if(foodsService.save(food) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(food);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Foods food){
        return foodsService.delete(food);
    }
}
