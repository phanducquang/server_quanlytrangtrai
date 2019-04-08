package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Employees;
import tk.giaiphapchannuoi.server.services.EmployeesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employees")
public class EmployeesController {

    @Autowired
    EmployeesService employeesService;

    @GetMapping(value = "/{id}")
    public Optional<Employees> findById(@PathVariable Integer id){
        return employeesService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Employees> findAll(){
        return employeesService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Employees employee){
        if(employeesService.save(employee) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(employee);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Employees employee){
        if(employeesService.save(employee) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Employees employee){
        return employeesService.delete(employee);
    }
}
