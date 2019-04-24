package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Issues;
import tk.giaiphapchannuoi.server.services.IssuesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/issues")
public class IssuesController {

    @Autowired
    IssuesService issuesService;

    @GetMapping(value = "/{id}")
    public Optional<Issues> findById(@PathVariable Integer id){
        return issuesService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Issues> findAll(){
        return issuesService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Issues issues){
        Issues temp = issuesService.save(issues);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(issues);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Issues issues){
        Issues temp = issuesService.update(issues);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(issues);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Issues issues){
        return issuesService.delete(issues);
    }
}
