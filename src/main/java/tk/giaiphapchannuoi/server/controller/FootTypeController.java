package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.FootType;
import tk.giaiphapchannuoi.server.services.FootTypeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/foottype")
public class FootTypeController {

    @Autowired
    FootTypeService footTypeService;

    @GetMapping(value = "/{id}")
    public Optional<FootType> findById(@PathVariable Integer id){
        return footTypeService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<FootType> findAll(){
        return footTypeService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody FootType footType){
        FootType temp = footTypeService.save(footType);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody FootType footType){
        FootType temp = footTypeService.update(footType);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody FootType footType){
        return footTypeService.delete(footType);
    }
}
