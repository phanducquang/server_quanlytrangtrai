package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.HealthStatus;
import tk.giaiphapchannuoi.server.services.HealthStatusService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/healthstatus")
public class HealthStatusController {

    @Autowired
    HealthStatusService healthStatusService;

    @GetMapping(value = "/{id}")
    public Optional<HealthStatus> findById(@PathVariable Integer id){
        return healthStatusService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<HealthStatus> findAll(){
        return healthStatusService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody HealthStatus healthStatus){
        if(healthStatusService.save(healthStatus) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(healthStatus);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody HealthStatus healthStatus){
        if(healthStatusService.save(healthStatus) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(healthStatus);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody HealthStatus healthStatus){
        return healthStatusService.delete(healthStatus);
    }
}
