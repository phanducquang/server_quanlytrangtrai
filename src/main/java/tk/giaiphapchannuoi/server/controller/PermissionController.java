package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Permisssions;
import tk.giaiphapchannuoi.server.services.PermissionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/permisssion")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @GetMapping(value = "/{id}")
    public Optional<Permisssions> findById(@PathVariable Integer id){
        return permissionService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Permisssions> findAll(){
        return permissionService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Permisssions permisssion){
        if(permissionService.save(permisssion) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(permisssion);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Permisssions permisssion){
        if(permissionService.save(permisssion) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(permisssion);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Permisssions permisssion){
        return permissionService.delete(permisssion);
    }
}
