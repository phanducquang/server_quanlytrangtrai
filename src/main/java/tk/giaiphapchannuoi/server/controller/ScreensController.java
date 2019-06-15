package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.Screens;
import tk.giaiphapchannuoi.server.services.ScreensService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/screens")
public class ScreensController {

    @Autowired
    ScreensService screensService;

    @GetMapping(value = "/one/{id}")
    public Optional<Screens> findById(@PathVariable Integer id){
        return screensService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<Screens> findAll(){
        return screensService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody Screens screen){
        Screens temp = screensService.save(screen);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody Screens screen){
        Screens temp = screensService.update(screen);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody Screens screen){
        return screensService.delete(screen);
    }
}
