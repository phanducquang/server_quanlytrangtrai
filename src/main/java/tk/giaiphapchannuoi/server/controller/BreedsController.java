package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Breeds;
import tk.giaiphapchannuoi.server.services.BreedsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/breeds")
public class BreedsController {

    @Autowired
    BreedsService breedsService;

    @GetMapping(value = "/{id}")
    public Optional<Breeds> findById(@PathVariable Integer id){
        return breedsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Breeds> findAll(){
        return breedsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Breeds breeds){
        if(breedsService.save(breeds) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(breeds);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Breeds breeds){
        if(breedsService.save(breeds) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(breeds);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Breeds breeds){
        return breedsService.delete(breeds);
    }

}
