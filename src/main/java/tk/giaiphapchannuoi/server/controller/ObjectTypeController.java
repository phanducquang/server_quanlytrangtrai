package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.ObjectType;
import tk.giaiphapchannuoi.server.services.ObjectTypeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/objecttype")
public class ObjectTypeController {

    @Autowired
    ObjectTypeService objectTypeService;

    @GetMapping(value = "/{id}")
    public Optional<ObjectType> findById(@PathVariable Integer id){
        return objectTypeService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<ObjectType> findAll(){
        return objectTypeService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody ObjectType objectType){
        ObjectType temp = objectTypeService.save(objectType);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody ObjectType objectType){
        ObjectType temp = objectTypeService.update(objectType);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody ObjectType objectType){
        return objectTypeService.delete(objectType);
    }
}
