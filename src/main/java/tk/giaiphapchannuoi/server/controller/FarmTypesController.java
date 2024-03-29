package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.FarmTypes;
import tk.giaiphapchannuoi.server.services.FarmTypesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/farmtypes")
public class FarmTypesController {

    @Autowired
    FarmTypesService farmTypeTypeService;

    @GetMapping(value = "/one/{id}")
    public Optional<FarmTypes> findById(@PathVariable Integer id){
        return farmTypeTypeService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<FarmTypes> findAll(){
        return farmTypeTypeService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody FarmTypes farmType){
        FarmTypes temp = farmTypeTypeService.save(farmType);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody FarmTypes farmType){
        FarmTypes temp = farmTypeTypeService.update(farmType);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody FarmTypes farmType){
        return farmTypeTypeService.delete(farmType);
    }
}
