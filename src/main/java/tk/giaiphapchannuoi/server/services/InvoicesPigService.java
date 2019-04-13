package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.InvoicesPig;
import tk.giaiphapchannuoi.server.repository.InvoicesPigRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InvoicesPigService {

    @Autowired
    InvoicesPigRepository invoicePigRepository;

    public List<InvoicesPig> findall(){
        return invoicePigRepository.findAllByDelFlag(false);
    }

    public Optional<InvoicesPig> findbyid(Integer id){
        return invoicePigRepository.findByIdAndDelFlag(id,false);
    }

    public InvoicesPig save(InvoicesPig invoicePig){
        invoicePig.setDelFlag(false);
        return invoicePigRepository.save(invoicePig);
    }

    public InvoicesPig update(InvoicesPig invoicePig){
        return invoicePigRepository.save(invoicePig);
    }


    public Boolean delete(InvoicesPig invoicePig){
        invoicePig.setDelFlag(true);
        if(invoicePigRepository.save(invoicePig) != null){
            return true;
        }
        return false;
    }
}
