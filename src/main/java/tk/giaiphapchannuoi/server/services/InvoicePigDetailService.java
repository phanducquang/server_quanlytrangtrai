package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.DTO.PigsInvoicePigDetailDTO;
import tk.giaiphapchannuoi.server.model.InvoicePigDetail;
import tk.giaiphapchannuoi.server.model.InvoicesPig;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.repository.InvoicePigDetailRepository;
import tk.giaiphapchannuoi.server.repository.InvoicesPigRepository;
import tk.giaiphapchannuoi.server.repository.PigsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InvoicePigDetailService {

    @Autowired
    InvoicePigDetailRepository invoicePigDetailRepository;

    @Autowired
    InvoicesPigRepository invoicesPigRepository;

    @Autowired
    PigsRepository pigsRepository;

    public List<InvoicePigDetail> findall(){
        return invoicePigDetailRepository.findAllByDelFlag(false);
    }

    public List<InvoicePigDetail> findbyinvoice(Integer id){
        Optional<InvoicesPig> invoicesPig = invoicesPigRepository.findByIdAndDelFlag(id,false);
        return invoicePigDetailRepository.findByInvoiceAndDelFlag(invoicesPig.get(), false);
    }

    public Optional<InvoicePigDetail> findbyid(Integer id){
        return invoicePigDetailRepository.findByIdAndDelFlag(id,false);
    }

    public InvoicePigDetail save(InvoicePigDetail invoicePigDetail){
        invoicePigDetail.setDelFlag(false);
        return invoicePigDetailRepository.save(invoicePigDetail);
    }

    @Transactional
    public PigsInvoicePigDetailDTO savePigsInvoicePigDetail(PigsInvoicePigDetailDTO pigsInvoicePigDetailDTO){
        pigsInvoicePigDetailDTO.getPigs().setDelFlag(false);
        pigsInvoicePigDetailDTO.getInvoicePigDetail().setDelFlag(false);
        Pigs pigs = pigsRepository.save(pigsInvoicePigDetailDTO.getPigs());
        InvoicePigDetail invoicePigDetail = save(pigsInvoicePigDetailDTO.getInvoicePigDetail());
        PigsInvoicePigDetailDTO temp = new PigsInvoicePigDetailDTO(pigs,invoicePigDetail);
        return temp;
    }

    public InvoicePigDetail update(InvoicePigDetail invoicePigDetail){
        return invoicePigDetailRepository.save(invoicePigDetail);
    }

    public Boolean delete(InvoicePigDetail invoicePigDetail){
        invoicePigDetail.setDelFlag(true);
        if(invoicePigDetailRepository.save(invoicePigDetail) != null){
            return true;
        }
        return false;
    }
}
