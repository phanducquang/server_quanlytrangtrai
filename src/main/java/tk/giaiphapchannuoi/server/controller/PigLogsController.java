package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.PigLogs;
import tk.giaiphapchannuoi.server.services.PigLogsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/piglogs")
public class PigLogsController {

    @Autowired
    PigLogsService pigLogsService;

    @GetMapping(value = "/{id}")
    public Optional<PigLogs> findById(@PathVariable Integer id){
        return pigLogsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<PigLogs> findAll(){
        return pigLogsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody PigLogs pigLogs){
        if(pigLogsService.save(pigLogs) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(pigLogs);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody PigLogs pigLogs){
        if(pigLogsService.save(pigLogs) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(pigLogs);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody PigLogs pigLogs){
        return pigLogsService.delete(pigLogs);
    }
}
