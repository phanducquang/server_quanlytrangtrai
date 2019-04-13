package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Sperm;
import tk.giaiphapchannuoi.server.services.SpermService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/sperm")
public class SpermController {

    @Autowired
    SpermService spermService;

    @GetMapping(value = "/{id}")
    public Optional<Sperm> findById(@PathVariable Integer id){
        return spermService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Sperm> findAll(){
        return spermService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Sperm sperm){
        Sperm temp = spermService.save(sperm);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Sperm sperm){
        Sperm temp = spermService.update(sperm);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Sperm sperm){
        return spermService.delete(sperm);
    }
}
