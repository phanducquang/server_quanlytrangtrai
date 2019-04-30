package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.giaiphapchannuoi.server.DTO.InvoicesDTO;
import tk.giaiphapchannuoi.server.services.InvoicesPigService;
import tk.giaiphapchannuoi.server.services.InvoicesProductService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/invoices")
public class InvoicesController {
    @Autowired
    InvoicesPigService invoicesPigService;

    @Autowired
    InvoicesProductService invoicesProductService;

    @GetMapping(value = "/list")
    public InvoicesDTO findAll(){
        InvoicesDTO invoicesDTO = new InvoicesDTO();
        invoicesDTO.setInvoicesPigs(invoicesPigService.findall());
        invoicesDTO.setInvoicesProducts(invoicesProductService.findall());
        return invoicesDTO;
    }
}
