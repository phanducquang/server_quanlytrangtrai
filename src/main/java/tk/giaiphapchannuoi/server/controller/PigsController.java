package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.services.PigsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pigs")
public class PigsController {

    @Autowired
    PigsService pigsService;

    @GetMapping(value = "/{id}")
    public Optional<Pigs> findById(@PathVariable Integer id){
        return pigsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Pigs> findAll(){
        return pigsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Pigs pig){
        if(pigsService.save(pig) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(pig);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Pigs pig){
        if(pigsService.save(pig) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(pig);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Pigs pig){
        return pigsService.delete(pig);
    }
}
