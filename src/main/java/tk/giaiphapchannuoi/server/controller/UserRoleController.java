package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.UserRole;
import tk.giaiphapchannuoi.server.services.UserRoleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/userrole")
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @GetMapping(value = "/{id}")
    public Optional<UserRole> findById(@PathVariable Integer id){
        return userRoleService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<UserRole> findAll(){
        return userRoleService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody UserRole userRole){
        UserRole temp = userRoleService.save(userRole);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody UserRole userRole){
        UserRole temp = userRoleService.update(userRole);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody UserRole userRole){
        return userRoleService.delete(userRole);
    }
}
