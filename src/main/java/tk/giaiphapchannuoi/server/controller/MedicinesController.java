package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Medicines;
import tk.giaiphapchannuoi.server.services.MedicinesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/medicines")
public class MedicinesController {

    @Autowired
    MedicinesService medicinesService;

    @GetMapping(value = "/one/{id}")
    public Optional<Medicines> findById(@PathVariable Integer id){
        return medicinesService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Medicines> findAll(){
        return medicinesService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Medicines medicine){
        Medicines temp = medicinesService.save(medicine);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Medicines medicine){
        Medicines temp = medicinesService.update(medicine);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Medicines medicine){
        return medicinesService.delete(medicine);
    }
}
