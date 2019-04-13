package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.BreedingType;
import tk.giaiphapchannuoi.server.services.BreedingTypeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/breedingtype")
public class BreedingTypeController {

    @Autowired
    BreedingTypeService breedingTypeService;

    @GetMapping(value = "/{id}")
    public Optional<BreedingType> findById(@PathVariable Integer id){
        return breedingTypeService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<BreedingType> findAll(){
        return breedingTypeService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody BreedingType breedingType){
        BreedingType temp = breedingTypeService.save(breedingType);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody BreedingType breedingType){
        BreedingType temp = breedingTypeService.update(breedingType);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody BreedingType breedingType){
        return breedingTypeService.delete(breedingType);
    }
}
