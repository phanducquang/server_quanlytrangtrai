package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.MatingDetails;
import tk.giaiphapchannuoi.server.services.MatingDetailsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/matingdetails")
public class MatingDetailsController {

    @Autowired
    MatingDetailsService matingDetailsService;

    @GetMapping(value = "/{id}")
    public Optional<MatingDetails> findById(@PathVariable Integer id){
        return matingDetailsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<MatingDetails> findAll(){
        return matingDetailsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody MatingDetails matingDetails){
        MatingDetails temp = matingDetailsService.save(matingDetails);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody MatingDetails matingDetails){
        MatingDetails temp = matingDetailsService.update(matingDetails);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody MatingDetails matingDetails){
        return matingDetailsService.delete(matingDetails);
    }
}
