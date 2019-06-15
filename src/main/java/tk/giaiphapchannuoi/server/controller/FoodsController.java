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
@RequestMapping(value = "/api/foods")
public class FoodsController {

    @Autowired
    FoodsService foodsService;

    @GetMapping(value = "/one/{id}")
    public Optional<Foods> findById(@PathVariable Integer id){
        return foodsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Foods> findAll(){
        return foodsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Foods food){
        Foods temp = foodsService.save(food);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Foods food){
        Foods temp = foodsService.update(food);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Foods food){
        return foodsService.delete(food);
    }
}
