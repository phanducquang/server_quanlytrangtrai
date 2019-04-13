package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Sections;
import tk.giaiphapchannuoi.server.services.SectionsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/sections")
public class SectionsController {

    @Autowired
    SectionsService sectionsService;

    @GetMapping(value = "/{id}")
    public Optional<Sections> findById(@PathVariable Integer id){
        return sectionsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Sections> findAll(){
        return sectionsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Sections section){
        Sections temp = sectionsService.save(section);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Sections section){
        Sections temp = sectionsService.update(section);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Sections section){
        return sectionsService.delete(section);
    }
}
