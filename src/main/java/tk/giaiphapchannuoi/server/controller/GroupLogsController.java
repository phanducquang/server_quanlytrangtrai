package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.GroupLogs;
import tk.giaiphapchannuoi.server.services.GroupLogsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/grouplogs")
public class GroupLogsController {

    @Autowired
    GroupLogsService groupLogsService;

    @GetMapping(value = "/{id}")
    public Optional<GroupLogs> findById(@PathVariable Integer id){
        return groupLogsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<GroupLogs> findAll(){
        return groupLogsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody GroupLogs groupLog){
        GroupLogs temp = groupLogsService.save(groupLog);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody GroupLogs groupLog){
        GroupLogs temp = groupLogsService.update(groupLog);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody GroupLogs groupLog){
        return groupLogsService.delete(groupLog);
    }
}
