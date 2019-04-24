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
@RequestMapping(value = "/api/marktypes")
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
        MarkTypes temp = markTypesService.save(markType);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody MarkTypes markType){
        MarkTypes temp = markTypesService.update(markType);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody MarkTypes markType){
        return markTypesService.delete(markType);
    }
}
