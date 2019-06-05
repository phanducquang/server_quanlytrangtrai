package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Cages;
import tk.giaiphapchannuoi.server.services.CagesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/houses")
public class CagesController {

    @Autowired
    CagesService cagesService;

    @GetMapping(value = "/{id}")
    public Optional<Cages> findById(@PathVariable Integer id){
        return cagesService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Cages> findAll(){
        return cagesService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Cages house){
        Cages temp = cagesService.save(house);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Cages house){
        Cages temp = cagesService.update(house);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Cages house){
        return cagesService.delete(house);
    }
}
