package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.CustomerTypes;
import tk.giaiphapchannuoi.server.services.CustomerTypesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/customertypes")
public class CustomerTypesController {

    @Autowired
    CustomerTypesService customerTypesService;

    @GetMapping(value = "/one/{id}")
    public Optional<CustomerTypes> findById(@PathVariable Integer id){
        return customerTypesService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<CustomerTypes> findAll(){
        return customerTypesService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody CustomerTypes customerTypes){
        CustomerTypes temp = customerTypesService.save(customerTypes);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody CustomerTypes customerTypes){
        CustomerTypes temp = customerTypesService.update(customerTypes);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody CustomerTypes customerTypes){
        return customerTypesService.delete(customerTypes);
    }
}
