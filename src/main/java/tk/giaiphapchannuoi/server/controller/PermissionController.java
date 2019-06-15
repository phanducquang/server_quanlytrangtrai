package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Permissions;
import tk.giaiphapchannuoi.server.services.PermissionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @GetMapping(value = "/one/{id}")
    public Optional<Permissions> findById(@PathVariable Integer id){
        return permissionService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Permissions> findAll(){
        return permissionService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Permissions permisssion){
        Permissions temp = permissionService.save(permisssion);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Permissions permisssion){
        Permissions temp = permissionService.update(permisssion);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Permissions permisssion){
        return permissionService.delete(permisssion);
    }
}
