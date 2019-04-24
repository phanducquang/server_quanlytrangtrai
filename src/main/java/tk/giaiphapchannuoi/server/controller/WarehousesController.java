package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.WarehouseType;
import tk.giaiphapchannuoi.server.model.Warehouses;
import tk.giaiphapchannuoi.server.services.WarehousesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/warehouses")
public class WarehousesController {

    @Autowired
    WarehousesService warehousesService;

    @GetMapping(value = "/{id}")
    public Optional<Warehouses> findById(@PathVariable Integer id){
        return warehousesService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Warehouses> findAll(){
        return warehousesService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Warehouses warehouse){
        Warehouses temp = warehousesService.save(warehouse);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Warehouses warehouse){
        Warehouses temp = warehousesService.update(warehouse);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Warehouses warehouse){
        return warehousesService.delete(warehouse);
    }
}
