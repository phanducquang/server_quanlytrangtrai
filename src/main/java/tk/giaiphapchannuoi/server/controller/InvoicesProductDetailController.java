package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.InvoicesProductDetail;
import tk.giaiphapchannuoi.server.services.InvoicesProductDetailService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/invoicesproductdetail")
public class InvoicesProductDetailController {

    @Autowired
    InvoicesProductDetailService invoicesProductDetailService;

    @GetMapping(value = "/{id}")
    public Optional<InvoicesProductDetail> findById(@PathVariable Integer id){
        return invoicesProductDetailService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<InvoicesProductDetail> findAll(){
        return invoicesProductDetailService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody InvoicesProductDetail invoiceProductDetail){
        if(invoicesProductDetailService.save(invoiceProductDetail) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(invoiceProductDetail);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody InvoicesProductDetail invoiceProductDetail){
        if(invoicesProductDetailService.save(invoiceProductDetail) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(invoiceProductDetail);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody InvoicesProductDetail invoiceProductDetail){
        return invoicesProductDetailService.delete(invoiceProductDetail);
    }
}
