package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Matings;
import tk.giaiphapchannuoi.server.services.MatingsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/matings")
public class MatingsController {

    @Autowired
    MatingsService matingsService;

    @GetMapping(value = "/{id}")
    public Optional<Matings> findById(@PathVariable Integer id){
        return matingsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Matings> findAll(){
        return matingsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Matings mating){
        if(matingsService.save(mating) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(mating);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Matings mating){
        if(matingsService.save(mating) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(mating);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Matings mating){
        return matingsService.delete(mating);
    }
}
