package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.DTO.InvoicesPigInvoicePigDetailDTOResponse;
import tk.giaiphapchannuoi.server.DTO.PigsInvoicePigDTORequest;
import tk.giaiphapchannuoi.server.DTO.PigsInvoicePigDTOResponse;
import tk.giaiphapchannuoi.server.DTO.PigsInvoicePigDetailDTOResponse;
import tk.giaiphapchannuoi.server.model.InvoicesPig;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.services.InvoicesPigService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/invoicespig")
public class InvoicesPigController {

    @Autowired
    InvoicesPigService invoicesPigService;

    @GetMapping(value = "/one/{id}")
    public Optional<InvoicesPig> findById(@PathVariable Integer id){
        return invoicesPigService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<InvoicesPig> findAll(){
        return invoicesPigService.findall();
    }

    @GetMapping(value = "/forwarding/list")
    public InvoicesPigInvoicePigDetailDTOResponse findAllByStatus(){
        return invoicesPigService.findbystatus("forwarding");
    }

    @Transactional
    @PostMapping(value = "/pigsinvoicepig/")
    public ResponseEntity<Object> insertcustom(@RequestBody PigsInvoicePigDTORequest pigsInvoicePigDTORequest){
        PigsInvoicePigDTOResponse pigsInvoicePigDTOResponse = invoicesPigService.savecustom(pigsInvoicePigDTORequest);
        if(pigsInvoicePigDTOResponse == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(pigsInvoicePigDTOResponse);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody InvoicesPig invoicePig){
        InvoicesPig temp = invoicesPigService.save(invoicePig);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody InvoicesPig invoicePig){
        InvoicesPig temp = invoicesPigService.update(invoicePig);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody InvoicesPig invoicePig){
        return invoicesPigService.delete(invoicePig);
    }
}
