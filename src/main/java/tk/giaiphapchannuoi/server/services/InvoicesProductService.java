package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Farms;
import tk.giaiphapchannuoi.server.model.InvoicesProduct;
import tk.giaiphapchannuoi.server.repository.FarmsRepository;
import tk.giaiphapchannuoi.server.repository.InvoicesProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InvoicesProductService {

    @Autowired
    InvoicesProductRepository invoicesProductRepository;

    @Autowired
    UsersService usersService;

    @Autowired
    FarmsRepository farmsRepository;

    public List<InvoicesProduct> findall(){
        Integer farmId = usersService.getFarmId();
        List<InvoicesProduct> temp = invoicesProductRepository.findAllByDelFlag(false);
        if (farmId.equals(0)){
            return temp;
        }
        List<InvoicesProduct> invoicesProductList = new ArrayList<>();
        for (InvoicesProduct ip :
                temp) {
            if (ip.getDestination().getId().equals(farmId)){
                invoicesProductList.add(ip);
            }
        }
        return invoicesProductList;
    }

    public Optional<InvoicesProduct> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<InvoicesProduct> invoicesProduct = invoicesProductRepository.findByIdAndDelFlag(id,false);
        if (invoicesProduct.isPresent()){
            if (invoicesProduct.get().getDestination().getId().equals(farmId) || farmId.equals(0)){
                return invoicesProduct;
            }
        }
        return Optional.empty();
    }

    public InvoicesProduct save(InvoicesProduct invoiceProduct){
        Integer farmId = usersService.getFarmId();
        if (farmId.equals(0) || invoiceProduct.getDestination().getId().equals(farmId)){
            invoiceProduct.setDelFlag(false);
            return invoicesProductRepository.save(invoiceProduct);
        }
        return null;
    }

    public InvoicesProduct update(InvoicesProduct invoiceProduct){
        Integer farmId = usersService.getFarmId();
        if (farmId.equals(0) || invoiceProduct.getDestination().getId().equals(farmId)){
            return invoicesProductRepository.save(invoiceProduct);
        }
        return null;
    }

    public Boolean delete(InvoicesProduct invoiceProduct){
        invoiceProduct.setDelFlag(true);
        if(update(invoiceProduct) != null){
            return true;
        }
        return false;
    }
}
