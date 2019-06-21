package tk.giaiphapchannuoi.server.controller;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Feeds;
import tk.giaiphapchannuoi.server.services.FeedsService;
import tk.giaiphapchannuoi.server.services.UsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/feeds")
public class FeedsController {

    @Autowired
    FeedsService feedsService;

    @Autowired
    UsersService usersService;

    @GetMapping(value = "/one/{id}")
    public Optional<Feeds> findById(@PathVariable Integer id){
        return feedsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Feeds> findAll(){
        return feedsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Feeds feed){
        Integer farmId = usersService.getFarmId();
        Feeds temp = feedsService.save(farmId, feed);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @Transactional
    @PostMapping(value = "/feedlist/")
    public ResponseEntity<Object> insertlist(@RequestBody List<Feeds> feed){
        List<Feeds> temp = feedsService.savelist(feed);
        if (temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("1432: so luong con lai khong du");
        }
        else if( temp.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Feeds feed){
        Feeds temp = feedsService.update(feed);
        if( temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Feeds feed){
        return feedsService.delete(feed);
    }
}
