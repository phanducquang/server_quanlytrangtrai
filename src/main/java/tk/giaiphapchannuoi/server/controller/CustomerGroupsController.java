package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.CustomerGroups;
import tk.giaiphapchannuoi.server.services.CustomerGroupsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customergroups")
public class CustomerGroupsController {

    @Autowired
    CustomerGroupsService customerGroupsService;

    @GetMapping(value = "/{id}")
    public Optional<CustomerGroups> findById(@PathVariable Integer id){
        return customerGroupsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<CustomerGroups> findAll(){
        return customerGroupsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody CustomerGroups customerGroups){
        if(customerGroupsService.save(customerGroups) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(customerGroups);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody CustomerGroups customerGroups){
        if(customerGroupsService.save(customerGroups) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(customerGroups);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody CustomerGroups customerGroups){
        return customerGroupsService.delete(customerGroups);
    }
}
