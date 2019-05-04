package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.FoodWarehouse;
import tk.giaiphapchannuoi.server.services.FoodWarehouseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/foodwarehouse")
public class FoodWarehouseController {

    @Autowired
    FoodWarehouseService foodWarehouseService;

    @GetMapping(value = "/{id}")
    public Optional<FoodWarehouse> findById(@PathVariable Integer id){
        return foodWarehouseService.findbyid(id);
    }

    @GetMapping(value = "/invoice/{invoiceId}")
    public List<FoodWarehouse> findByInvoice(@PathVariable Integer invoiceId){
        return foodWarehouseService.findbyinvoices(invoiceId);
    }

    @GetMapping(value = "/list")
    public List<FoodWarehouse> findAll(){
        return foodWarehouseService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody FoodWarehouse foodWarehouse){
        FoodWarehouse temp = foodWarehouseService.save(foodWarehouse);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody FoodWarehouse foodWarehouse){
        FoodWarehouse temp = foodWarehouseService.update(foodWarehouse);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody FoodWarehouse foodWarehouse){
        return foodWarehouseService.delete(foodWarehouse);
    }
}
