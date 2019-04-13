package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Diseases;
import tk.giaiphapchannuoi.server.services.DiseasesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/diseases")
public class DiseasesController {

    @Autowired
    DiseasesService diseasesService;

    @GetMapping(value = "/{id}")
    public Optional<Diseases> findById(@PathVariable Integer id){
        return diseasesService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Diseases> findAll(){
        return diseasesService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Diseases diseases){
        Diseases temp = diseasesService.save(diseases);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Diseases diseases){
        Diseases temp = diseasesService.update(diseases);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Diseases diseases){
        return diseasesService.delete(diseases);
    }
}
