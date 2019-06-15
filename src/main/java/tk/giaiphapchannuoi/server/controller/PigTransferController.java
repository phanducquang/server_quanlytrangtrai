package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.PigTransfer;
import tk.giaiphapchannuoi.server.services.PigTransferService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/pigtransfer")
public class PigTransferController {

    @Autowired
    PigTransferService pigTransferService;

    @GetMapping(value = "/one/{id}")
    public Optional<PigTransfer> findById(@PathVariable Integer id){
        return pigTransferService.findbyid(id);
    }

    @GetMapping(value = "/pigwaiting/{pigId}")
    public PigTransfer findByPig(@PathVariable Integer pigId){
        return pigTransferService.findbypigandstatuswaiting(pigId);
    }

    @GetMapping(value = "/pigfinish/{pigId}")
    public List<PigTransfer> findByPigFinish(@PathVariable Integer pigId){
        return pigTransferService.findbypigandstatusfinish(pigId);
    }

    @GetMapping(value = "/allpigwaiting/")
    public List<PigTransfer> findAllByStatusWaiting(@PathVariable Integer pigId){
        return pigTransferService.findbypigandstatusfinish(pigId);
    }

    @GetMapping(value = "/listpig/{pigId}")
    public List<PigTransfer> findAllByPig(@PathVariable Integer pigId){
        return pigTransferService.findbypig(pigId);
    }

    @GetMapping(value = "/list")
    public List<PigTransfer> findAll(){
        return pigTransferService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody PigTransfer pigTransfer){
        PigTransfer temp = pigTransferService.save(pigTransfer);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody PigTransfer pigTransfer){
        PigTransfer temp = pigTransferService.update(pigTransfer);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody PigTransfer pigTransfer){
        return pigTransferService.delete(pigTransfer);
    }
}
