package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.PregnancyStatus;
import tk.giaiphapchannuoi.server.services.PregnancyStatusService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pregnancystatus")
public class PregnancyStatusController {

    @Autowired
    PregnancyStatusService pregnancyStatusService;

    @GetMapping(value = "/{id}")
    public Optional<PregnancyStatus> findById(@PathVariable Integer id){
        return pregnancyStatusService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<PregnancyStatus> findAll(){
        return pregnancyStatusService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody PregnancyStatus pregnancyStatus){
        PregnancyStatus temp = pregnancyStatusService.save(pregnancyStatus);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody PregnancyStatus pregnancyStatus){
        PregnancyStatus temp = pregnancyStatusService.update(pregnancyStatus);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody PregnancyStatus pregnancyStatus){
        return pregnancyStatusService.delete(pregnancyStatus);
    }
}
