package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.MarkTypes;
import tk.giaiphapchannuoi.server.services.MarkTypesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/marktypes")
public class MarkTypesController {

    @Autowired
    MarkTypesService markTypesService;

    @GetMapping(value = "/{id}")
    public Optional<MarkTypes> findById(@PathVariable Integer id){
        return markTypesService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<MarkTypes> findAll(){
        return markTypesService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody MarkTypes markType){
        if(markTypesService.save(markType) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(markType);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody MarkTypes markType){
        if(markTypesService.save(markType) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(markType);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody MarkTypes markType){
        return markTypesService.delete(markType);
    }
}
