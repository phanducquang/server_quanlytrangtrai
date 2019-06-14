package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Permissions;
import tk.giaiphapchannuoi.server.model.RolePermission;
import tk.giaiphapchannuoi.server.services.RolePermissionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/rolepermission")
public class RolePermissionController {

    @Autowired
    RolePermissionService rolePermissionService;

    @GetMapping(value = "/{id}")
    public Optional<RolePermission> findById(@PathVariable Integer id){
        return rolePermissionService.findbyid(id);
    }

    @GetMapping(value = "/role/{id}")
    public List<Permissions> findByRole(@PathVariable Integer id){
        return rolePermissionService.findbyrole(id);
    }


    @GetMapping(value = "/list")
    public List<RolePermission> findAll(){
        return rolePermissionService.findall();
    }

    @Transactional
    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody List<RolePermission> rolePermission){
        List<RolePermission> temp = rolePermissionService.save(rolePermission);
        if(temp.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody List<RolePermission> rolePermission){
        List<RolePermission> temp = rolePermissionService.update(rolePermission);
        if(temp.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody RolePermission rolePermission){
        return rolePermissionService.delete(rolePermission);
    }
}
