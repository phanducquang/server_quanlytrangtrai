package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.WarehouseTransaction;
import tk.giaiphapchannuoi.server.services.WarehouseTransactionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/warehousetransaction")
public class WarehouseTransactionController {

    @Autowired
    WarehouseTransactionService warehouseTransactionService;

    @GetMapping(value = "/{id}")
    public Optional<WarehouseTransaction> findById(@PathVariable Integer id){
        return warehouseTransactionService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<WarehouseTransaction> findAll(){
        return warehouseTransactionService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody WarehouseTransaction warehouseTransaction){
        if(warehouseTransactionService.save(warehouseTransaction) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(warehouseTransaction);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody WarehouseTransaction warehouseTransaction){
        if(warehouseTransactionService.save(warehouseTransaction) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(warehouseTransaction);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody WarehouseTransaction warehouseTransaction){
        return warehouseTransactionService.delete(warehouseTransaction);
    }
}
