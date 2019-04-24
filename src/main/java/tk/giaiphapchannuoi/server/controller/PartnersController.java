package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Partners;
import tk.giaiphapchannuoi.server.services.PartnersService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/partners")
public class PartnersController {

    @Autowired
    PartnersService partnersService;

    @GetMapping(value = "/{id}")
    public Optional<Partners> findById(@PathVariable Integer id){
        return partnersService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Partners> findAll(){
        return partnersService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Partners partner){
        Partners temp = partnersService.save(partner);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Partners partner){
        Partners temp = partnersService.update(partner);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Partners partner){
        return partnersService.delete(partner);
    }
}
