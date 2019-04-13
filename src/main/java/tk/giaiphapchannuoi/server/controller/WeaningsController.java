package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Weanings;
import tk.giaiphapchannuoi.server.services.WeaningsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/weanings")
public class WeaningsController {

    @Autowired
    WeaningsService weaningsService;

    @GetMapping(value = "/{id}")
    public Optional<Weanings> findById(@PathVariable Integer id){
        return weaningsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Weanings> findAll(){
        return weaningsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Weanings weaning){
        Weanings temp = weaningsService.save(weaning);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Weanings weaning){
        Weanings temp = weaningsService.update(weaning);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Weanings weaning){
        return weaningsService.delete(weaning);
    }
}
