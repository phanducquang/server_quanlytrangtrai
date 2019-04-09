package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.InvoicesProduct;
import tk.giaiphapchannuoi.server.services.InvoicesProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/invoicesproduct")
public class InvoicesProductController {

    @Autowired
    InvoicesProductService invoicesProductService;

    @GetMapping(value = "/{id}")
    public Optional<InvoicesProduct> findById(@PathVariable Integer id){
        return invoicesProductService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<InvoicesProduct> findAll(){
        return invoicesProductService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody InvoicesProduct invoiceProduct){
        if(invoicesProductService.save(invoiceProduct) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(invoiceProduct);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody InvoicesProduct invoiceProduct){
        if(invoicesProductService.save(invoiceProduct) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(invoiceProduct);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody InvoicesProduct invoiceProduct){
        return invoicesProductService.delete(invoiceProduct);
    }
}
