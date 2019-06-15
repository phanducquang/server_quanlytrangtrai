package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Births;
import tk.giaiphapchannuoi.server.services.BirthsService;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/births")
public class BirthsController {

    @Autowired
    BirthsService birthsService;

    @GetMapping(value = "/one/{id}")
    public Births findById(@PathVariable Integer id){
        return birthsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Births> findAll(){
        return birthsService.findall();
    }

    @Transactional
    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Births births){
        Births temp = birthsService.save(births);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Births births){
        Births temp = birthsService.update(births);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Births births){
        return birthsService.delete(births);
    }
}
