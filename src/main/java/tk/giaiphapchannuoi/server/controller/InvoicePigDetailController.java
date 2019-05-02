package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.DTO.PigsInvoicePigDetailDTO;
import tk.giaiphapchannuoi.server.model.InvoicePigDetail;
import tk.giaiphapchannuoi.server.services.InvoicePigDetailService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/invoicepigdetail")
public class InvoicePigDetailController {

    @Autowired
    InvoicePigDetailService invoicePigDetailService;

    @GetMapping(value = "/{id}")
    public Optional<InvoicePigDetail> findById(@PathVariable Integer id){
        return invoicePigDetailService.findbyid(id);
    }

    @GetMapping(value = "/invoice/{id}")
    public List<InvoicePigDetail> findByInvoice(@PathVariable Integer id){
        return invoicePigDetailService.findbyinvoice(id);
    }

    @GetMapping(value = "/list")
    public List<InvoicePigDetail> findAll(){
        return invoicePigDetailService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody InvoicePigDetail invoicePigDetail){
        InvoicePigDetail temp = invoicePigDetailService.save(invoicePigDetail);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @Transactional
    @PostMapping(value = "/pigsinvoicepigdetail/")
    public ResponseEntity<Object> insertPig_PigInvoiceDetail(@RequestBody PigsInvoicePigDetailDTO pigsInvoicePigDetailDTO){

        PigsInvoicePigDetailDTO temp = invoicePigDetailService.savePigsInvoicePigDetail(pigsInvoicePigDetailDTO);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody InvoicePigDetail invoicePigDetail){
        InvoicePigDetail temp = invoicePigDetailService.update(invoicePigDetail);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody InvoicePigDetail invoicePigDetail){
        return invoicePigDetailService.delete(invoicePigDetail);
    }
}
