package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.GroupPermission;
import tk.giaiphapchannuoi.server.services.GroupPermissionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/grouppermission")
public class GroupPermissonController {

    @Autowired
    GroupPermissionService groupPermissionService;

    @GetMapping(value = "/{id}")
    public Optional<GroupPermission> findById(@PathVariable Integer id){
        return groupPermissionService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<GroupPermission> findAll(){
        return groupPermissionService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody GroupPermission groupPermission){
        if(groupPermissionService.save(groupPermission) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(groupPermission);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody GroupPermission groupPermission){
        if(groupPermissionService.save(groupPermission) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(groupPermission);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody GroupPermission groupPermission){
        return groupPermissionService.delete(groupPermission);
    }
}
