package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.GentialType;
import tk.giaiphapchannuoi.server.services.GentialTypeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/gentialtype")
public class GentialTypeController {

    @Autowired
    GentialTypeService gentialTypeService;

    @GetMapping(value = "/{id}")
    public Optional<GentialType> findById(@PathVariable Integer id){
        return gentialTypeService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<GentialType> findAll(){
        return gentialTypeService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody GentialType gentialType){
        if(gentialTypeService.save(gentialType) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(gentialType);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody GentialType gentialType){
        if(gentialTypeService.save(gentialType) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(gentialType);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody GentialType gentialType){
        return gentialTypeService.delete(gentialType);
    }
}
