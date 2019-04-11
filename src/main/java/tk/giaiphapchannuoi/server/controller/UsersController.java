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
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping(value = "/{id}")
    public Optional<Users> findById(@PathVariable Integer id){
        return usersService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Users> findAll(){
        return usersService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Users user){
        if(usersService.save(user) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Users user){
        if(usersService.save(user) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Users user){
        return usersService.delete(user);
    }
}
