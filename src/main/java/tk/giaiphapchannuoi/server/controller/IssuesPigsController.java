package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.DTO.TiLeDiseasesDTO;
import tk.giaiphapchannuoi.server.model.Diseases;
import tk.giaiphapchannuoi.server.model.IssuesPigs;
import tk.giaiphapchannuoi.server.services.IssuesPigsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/issuespigs")
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

    @GetMapping(value = "/listcurrentissues")
    public List<IssuesPigs> findCurrentIssues(){
        return issuesPigsService.findcurrentissues();
    }

    @GetMapping(value = "/forecastdiseases")
    public List<TiLeDiseasesDTO> forecastDiseases(){
        return issuesPigsService.forecastdiseases();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody List<IssuesPigs> issuesPigsList){
        List<IssuesPigs> issuesPigs = new ArrayList<>();
        for (IssuesPigs issuesPig :
                issuesPigsList) {
            issuesPigs.add(issuesPigsService.save(issuesPig));
        }
        if(issuesPigs.size() == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(issuesPigs);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody IssuesPigs issuesPig){
        IssuesPigs temp = issuesPigsService.update(issuesPig);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody IssuesPigs issuesPig){
        return issuesPigsService.delete(issuesPig);
    }
}
