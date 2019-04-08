package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Customers;
import tk.giaiphapchannuoi.server.services.CustomersService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customers")
public class CustomersController {

    @Autowired
    CustomersService customersService;

    @GetMapping(value = "/{id}")
    public Optional<Customers> findById(@PathVariable Integer id){
        return customersService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Customers> findAll(){
        return customersService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Customers customers){
        if(customersService.save(customers) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(customers);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Customers customers){
        if(customersService.save(customers) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(customers);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Customers customers){
        return customersService.delete(customers);
    }
}
