package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.InvoicesPig;
import tk.giaiphapchannuoi.server.services.InvoicesPigService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/invoicespig")
public class InvoicesPigController {

    @Autowired
    InvoicesPigService invoicesPigService;

    @GetMapping(value = "/{id}")
    public Optional<InvoicesPig> findById(@PathVariable Integer id){
        return invoicesPigService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<InvoicesPig> findAll(){
        return invoicesPigService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody InvoicesPig invoicePig){
        if(invoicesPigService.save(invoicePig) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(invoicePig);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody InvoicesPig invoicePig){
        if(invoicesPigService.save(invoicePig) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(invoicePig);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody InvoicesPig invoicePig){
        return invoicesPigService.delete(invoicePig);
    }
}
