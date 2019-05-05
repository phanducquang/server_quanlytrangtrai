package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Status;
import tk.giaiphapchannuoi.server.services.StatusService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/status")
public class StatusController {

    @Autowired
    StatusService statusService;

    @GetMapping(value = "/{id}")
    public Optional<Status> findById(@PathVariable Integer id){
        return statusService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Status> findAll(){
        return statusService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Status status){
        Status temp = statusService.save(status);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Status status){
        Status temp = statusService.update(status);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Status status){
        return statusService.delete(status);
    }
}
