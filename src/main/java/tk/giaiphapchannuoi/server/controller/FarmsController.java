package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Farms;
import tk.giaiphapchannuoi.server.services.FarmsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/farms")
public class FarmsController {

    @Autowired
    FarmsService farmsService;

    @GetMapping(value = "/one/{id}")
    public Optional<Farms> findById(@PathVariable Integer id){
        return farmsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Farms> findAll(){
        return farmsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Farms farm){
        Farms temp = farmsService.save(farm);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Farms farm){
        Farms temp = farmsService.update(farm);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Farms farm){
        return farmsService.delete(farm);
    }
}
