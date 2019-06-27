package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.DTO.PigsInvoicePigDetailDTORequest;
import tk.giaiphapchannuoi.server.DTO.PigsInvoicePigDetailDTOResponse;
import tk.giaiphapchannuoi.server.model.InvoicePigDetail;
import tk.giaiphapchannuoi.server.services.InvoicePigDetailService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/invoicepigdetail")
public class InvoicePigDetailController {

    @Autowired
    InvoicePigDetailService invoicePigDetailService;

    @GetMapping(value = "/one/{id}")
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

    //Nhap heo ngoai he thong
    @Transactional
    @PostMapping(value = "/pigsinvoicepigdetail/")
    public ResponseEntity<Object> insertPig_PigInvoiceDetail(@RequestBody PigsInvoicePigDetailDTORequest pigsInvoicePigDetailDTORequest){

        PigsInvoicePigDetailDTOResponse temp = invoicePigDetailService.savePigsInvoicePigDetail(pigsInvoicePigDetailDTORequest);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    //Nhap heo ngoai he thong
    @Transactional
    @PutMapping(value = "/updatepigininvoicepig/")
    public ResponseEntity<Object> updatePigInInvoicePig(@RequestBody PigsInvoicePigDetailDTORequest pigsInvoicePigDetailDTORequest){

        PigsInvoicePigDetailDTORequest temp = invoicePigDetailService.updatePigInInvoicePig(pigsInvoicePigDetailDTORequest);
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

    @Transactional
    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody InvoicePigDetail invoicePigDetail){
        return invoicePigDetailService.delete(invoicePigDetail);
    }

    @Transactional
    @DeleteMapping(value = "/onlyinvoicedetail")
    public Boolean deleteonlyinvoicedetail(@RequestBody InvoicePigDetail invoicePigDetail){
        return invoicePigDetailService.deleteonlyinvoicedetail(invoicePigDetail);
    }
}
