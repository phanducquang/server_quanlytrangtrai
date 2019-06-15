package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Roles;
import tk.giaiphapchannuoi.server.services.RolesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/roles")
public class RolesController {

    @Autowired
    RolesService rolesService;

    @GetMapping(value = "/one/{id}")
    public Optional<Roles> findById(@PathVariable Integer id){
        return rolesService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Roles> findAll(){
        return rolesService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Roles role){
        Roles temp = rolesService.save(role);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Roles role){
        Roles temp = rolesService.save(role);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Roles role){
        return rolesService.delete(role);
    }
}
