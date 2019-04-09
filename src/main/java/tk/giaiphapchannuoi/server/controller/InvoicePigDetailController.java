package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.InvoicePigDetail;
import tk.giaiphapchannuoi.server.services.InvoicePigDetailService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/invoicepigdetail")
public class InvoicePigDetailController {

    @Autowired
    InvoicePigDetailService invoicePigDetailService;

    @GetMapping(value = "/{id}")
    public Optional<InvoicePigDetail> findById(@PathVariable Integer id){
        return invoicePigDetailService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<InvoicePigDetail> findAll(){
        return invoicePigDetailService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody InvoicePigDetail invoicePigDetail){
        if(invoicePigDetailService.save(invoicePigDetail) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(invoicePigDetail);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody InvoicePigDetail invoicePigDetail){
        if(invoicePigDetailService.save(invoicePigDetail) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(invoicePigDetail);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody InvoicePigDetail invoicePigDetail){
        return invoicePigDetailService.delete(invoicePigDetail);
    }
}
