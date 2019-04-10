package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.MatingRoles;
import tk.giaiphapchannuoi.server.services.MatingRolesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/matingroles")
public class MatingRolesController {

    @Autowired
    MatingRolesService matingRolesService;

    @GetMapping(value = "/{id}")
    public Optional<MatingRoles> findById(@PathVariable Integer id){
        return matingRolesService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<MatingRoles> findAll(){
        return matingRolesService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody MatingRoles matingRole){
        if(matingRolesService.save(matingRole) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(matingRole);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody MatingRoles matingRole){
        if(matingRolesService.save(matingRole) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(matingRole);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody MatingRoles matingRole){
        return matingRolesService.delete(matingRole);
    }
}
