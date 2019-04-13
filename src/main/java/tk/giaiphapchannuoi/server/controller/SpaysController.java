package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Spays;
import tk.giaiphapchannuoi.server.services.SpaysService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/spays")
public class SpaysController {

    @Autowired
    SpaysService spaysService;

    @GetMapping(value = "/{id}")
    public Optional<Spays> findById(@PathVariable Integer id){
        return spaysService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Spays> findAll(){
        return spaysService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Spays spay){
        Spays temp = spaysService.save(spay);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Spays spay){
        Spays temp = spaysService.update(spay);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Spays spay){
        return spaysService.delete(spay);
    }
}
