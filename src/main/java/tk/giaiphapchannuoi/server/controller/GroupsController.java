package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Groups;
import tk.giaiphapchannuoi.server.services.GroupsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/groups")
public class GroupsController {

    @Autowired
    GroupsService groupsService;

    @GetMapping(value = "/{id}")
    public Optional<Groups> findById(@PathVariable Integer id){
        return groupsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Groups> findAll(){
        return groupsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Groups group){
        Groups temp = groupsService.save(group);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Groups group){
        Groups temp = groupsService.update(group);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Groups group){
        return groupsService.delete(group);
    }
}
