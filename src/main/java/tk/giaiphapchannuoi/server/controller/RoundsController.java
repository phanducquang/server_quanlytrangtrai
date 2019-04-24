package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Rounds;
import tk.giaiphapchannuoi.server.services.RoundsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/rounds")
public class RoundsController {

    @Autowired
    RoundsService roundsService;

    @GetMapping(value = "/{id}")
    public Optional<Rounds> findById(@PathVariable Integer id){
        return roundsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Rounds> findAll(){
        return roundsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Rounds round){
        Rounds temp = roundsService.save(round);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Rounds round){
        Rounds temp = roundsService.update(round);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Rounds round){
        return roundsService.delete(round);
    }
}
