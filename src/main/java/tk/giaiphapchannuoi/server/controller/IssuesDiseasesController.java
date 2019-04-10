package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.IssuesDiseases;
import tk.giaiphapchannuoi.server.services.IssuesDiseasesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/issuesdiseases")
public class IssuesDiseasesController {

    @Autowired
    IssuesDiseasesService issuesDiseasesService;

    @GetMapping(value = "/{id}")
    public Optional<IssuesDiseases> findById(@PathVariable Integer id){
        return issuesDiseasesService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<IssuesDiseases> findAll(){
        return issuesDiseasesService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody IssuesDiseases issuesDisease){
        if(issuesDiseasesService.save(issuesDisease) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(issuesDisease);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody IssuesDiseases issuesDisease){
        if(issuesDiseasesService.save(issuesDisease) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(issuesDisease);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody IssuesDiseases issuesDisease){
        return issuesDiseasesService.delete(issuesDisease);
    }
}
