package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Users;
import tk.giaiphapchannuoi.server.services.UsersService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping(value = "/{id}")
    public Optional<Users> findById(@PathVariable Integer id){
        return usersService.findbyid(id);
    }

    @GetMapping(value = "/username/{username}")
    public Optional<Users> findByUsername(@PathVariable String username){
        return usersService.findbyusername(username);
    }

    @GetMapping(value = "/list")
    public List<Users> findAll(){
        return usersService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Users user){
        Users temp = usersService.save(user);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Users user){
        Users temp = usersService.update(user);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/update_password")
    public ResponseEntity<Object> updatePassword(@RequestBody Users user){
        Users temp = usersService.updatePassword(user);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Users user){
        return usersService.delete(user);
    }
}
