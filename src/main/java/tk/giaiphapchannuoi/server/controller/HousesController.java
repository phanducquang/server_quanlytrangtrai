package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Houses;
import tk.giaiphapchannuoi.server.services.HousesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/houses")
public class HousesController {

    @Autowired
    HousesService housesService;

    @GetMapping(value = "/{id}")
    public Optional<Houses> findById(@PathVariable Integer id){
        return housesService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Houses> findAll(){
        return housesService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Houses house){
        if(housesService.save(house) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(house);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Houses house){
        if(housesService.save(house) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(house);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Houses house){
        return housesService.delete(house);
    }
}
