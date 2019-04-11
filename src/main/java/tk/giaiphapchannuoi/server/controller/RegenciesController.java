package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Regencies;
import tk.giaiphapchannuoi.server.services.RegenciesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/regencies")
public class RegenciesController {

    @Autowired
    RegenciesService regenciesService;

    @GetMapping(value = "/{id}")
    public Optional<Regencies> findById(@PathVariable Integer id){
        return regenciesService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Regencies> findAll(){
        return regenciesService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Regencies regency){
        if(regenciesService.save(regency) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(regency);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Regencies regency){
        if(regenciesService.save(regency) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(regency);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Regencies regency){
        return regenciesService.delete(regency);
    }
}
