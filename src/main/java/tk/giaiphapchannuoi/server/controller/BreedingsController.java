package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Breedings;
import tk.giaiphapchannuoi.server.services.BreedingsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/breedings")
public class BreedingsController {

    @Autowired
    BreedingsService breedingsService;

    @GetMapping(value = "/{id}")
    public Optional<Breedings> findBirth(@PathVariable Integer id){
        return breedingsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Breedings> findAll(){
        return breedingsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Breedings breedings){
        if(breedingsService.save(breedings) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(breedings);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Breedings breedings){
        if(breedingsService.save(breedings) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(breedings);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Breedings breedings){
        return breedingsService.delete(breedings);
    }
}
