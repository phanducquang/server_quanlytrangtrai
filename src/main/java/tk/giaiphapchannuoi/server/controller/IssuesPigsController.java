package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.IssuesPigs;
import tk.giaiphapchannuoi.server.services.IssuesPigsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/issuespigs")
public class IssuesPigsController {

    @Autowired
    IssuesPigsService issuesPigsService;

    @GetMapping(value = "/{id}")
    public Optional<IssuesPigs> findById(@PathVariable Integer id){
        return issuesPigsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<IssuesPigs> findAll(){
        return issuesPigsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody IssuesPigs issuesPig){
        if(issuesPigsService.save(issuesPig) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(issuesPig);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody IssuesPigs issuesPig){
        if(issuesPigsService.save(issuesPig) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(issuesPig);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody IssuesPigs issuesPig){
        return issuesPigsService.delete(issuesPig);
    }
}
