package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.WarehouseType;
import tk.giaiphapchannuoi.server.services.WarehouseTypeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/warehousetype")
public class WarehouseTypeController {

    @Autowired
    WarehouseTypeService warehouseTypeService;

    @GetMapping(value = "/{id}")
    public Optional<WarehouseType> findById(@PathVariable Integer id){
        return warehouseTypeService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<WarehouseType> findAll(){
        return warehouseTypeService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody WarehouseType warehouseType){
        WarehouseType temp = warehouseTypeService.save(warehouseType);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody WarehouseType warehouseType){
        WarehouseType temp = warehouseTypeService.update(warehouseType);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody WarehouseType warehouseType){
        return warehouseTypeService.delete(warehouseType);
    }
}
