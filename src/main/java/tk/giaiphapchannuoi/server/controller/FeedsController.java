package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Feeds;
import tk.giaiphapchannuoi.server.services.FeedsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/feeds")
public class FeedsController {

    @Autowired
    FeedsService feedsService;

    @GetMapping(value = "/{id}")
    public Optional<Feeds> findById(@PathVariable Integer id){
        return feedsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Feeds> findAll(){
        return feedsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Feeds feed){
        if(feedsService.save(feed) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(feed);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Feeds feed){
        if(feedsService.save(feed) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(feed);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Feeds feed){
        return feedsService.delete(feed);
    }
}
