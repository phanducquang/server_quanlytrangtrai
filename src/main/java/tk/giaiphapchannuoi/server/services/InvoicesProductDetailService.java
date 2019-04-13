package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.InvoicesProductDetail;
import tk.giaiphapchannuoi.server.repository.InvoicesProductDetailRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InvoicesProductDetailService {
    @Autowired
    InvoicesProductDetailRepository invoicesProductDetailRepository;

    public List<InvoicesProductDetail> findall(){
        return invoicesProductDetailRepository.findAllByDelFlag(false);
    }

    public Optional<InvoicesProductDetail> findbyid(Integer id){
        return invoicesProductDetailRepository.findByIdAndDelFlag(id,false);
    }

    public InvoicesProductDetail save(InvoicesProductDetail invoiceProductDetail){
        invoiceProductDetail.setDelFlag(false);
        return invoicesProductDetailRepository.save(invoiceProductDetail);
    }

    public InvoicesProductDetail update(InvoicesProductDetail invoiceProductDetail){
        return invoicesProductDetailRepository.save(invoiceProductDetail);
    }

    public Boolean delete(InvoicesProductDetail invoiceProductDetail){
        invoiceProductDetail.setDelFlag(true);
        if(invoicesProductDetailRepository.save(invoiceProductDetail) != null){
            return true;
        }
        return false;
    }
}
