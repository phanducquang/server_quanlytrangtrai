package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.RolePermission;
import tk.giaiphapchannuoi.server.services.RolePermissionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/rolepermission")
public class RolePermissionController {

    @Autowired
    RolePermissionService rolePermissionService;

    @GetMapping(value = "/{id}")
    public Optional<RolePermission> findById(@PathVariable Integer id){
        return rolePermissionService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<RolePermission> findAll(){
        return rolePermissionService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody RolePermission rolePermission){
        if(rolePermissionService.save(rolePermission) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(rolePermission);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody RolePermission rolePermission){
        if(rolePermissionService.save(rolePermission) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(rolePermission);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody RolePermission rolePermission){
        return rolePermissionService.delete(rolePermission);
    }
}
