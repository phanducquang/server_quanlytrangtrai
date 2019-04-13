package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.InvoicesProduct;
import tk.giaiphapchannuoi.server.repository.InvoicesProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InvoicesProductService {

    @Autowired
    InvoicesProductRepository invoicesProductRepository;

    public List<InvoicesProduct> findall(){
        return invoicesProductRepository.findAllByDelFlag(false);
    }

    public Optional<InvoicesProduct> findbyid(Integer id){
        return invoicesProductRepository.findByIdAndDelFlag(id,false);
    }

    public InvoicesProduct save(InvoicesProduct invoiceProduct){
        invoiceProduct.setDelFlag(false);
        return invoicesProductRepository.save(invoiceProduct);
    }

    public InvoicesProduct update(InvoicesProduct invoiceProduct){
        return invoicesProductRepository.save(invoiceProduct);
    }

    public Boolean delete(InvoicesProduct invoiceProduct){
        invoiceProduct.setDelFlag(true);
        if(invoicesProductRepository.save(invoiceProduct) != null){
            return true;
        }
        return false;
    }
}
