package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.DTO.InvoicesPigInvoicePigDetailDTOResponse;
import tk.giaiphapchannuoi.server.model.InvoicePigDetail;
import tk.giaiphapchannuoi.server.model.InvoicesPig;
import tk.giaiphapchannuoi.server.repository.InvoicePigDetailRepository;
import tk.giaiphapchannuoi.server.repository.InvoicesPigRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InvoicesPigService {

    @Autowired
    InvoicesPigRepository invoicePigRepository;

    @Autowired
    InvoicePigDetailRepository invoicePigDetailRepository;

    @Autowired
    UsersService usersService;

    public List<InvoicesPig> findall(){
        return invoicePigRepository.findAllByDelFlag(false);
    }

    public Optional<InvoicesPig> findbyid(Integer id){
        return invoicePigRepository.findByIdAndDelFlag(id,false);
    }

    public InvoicesPigInvoicePigDetailDTOResponse findbystatus(String status){
        Integer farmId = usersService.getFarmId();
        InvoicesPigInvoicePigDetailDTOResponse response = new InvoicesPigInvoicePigDetailDTOResponse();
        List<InvoicesPig> invoicesPigList = invoicePigRepository.findByStatusAndDelFlag(status,false);
        if (farmId != 0){
            List<InvoicesPig> temp = new ArrayList<>();
            List<InvoicePigDetail> temp1 = new ArrayList<>();
            for (InvoicesPig ip :
                    invoicesPigList) {
                if(ip.getInvoiceType().equals("external-import")){
                    if (ip.getDestinationId().equals(farmId)){
                        temp.add(ip);
                    }
                } else if(ip.getInvoiceType().equals("internal-export")){
                    if (ip.getSourceId().equals(farmId)){
                        temp.add(ip);
                    }
                } else if (ip.getInvoiceType().equals("internal-import")){
                    if (ip.getDestinationId().equals(farmId)){
                        temp.add(ip);
                    }
                }
            }
            for (InvoicesPig ip :
                    temp) {
                temp1.addAll(invoicePigDetailRepository.findByInvoiceAndDelFlag(ip,false));
            }
            response.setInvoicesPig(temp);
            response.setInvoicePigDetail(temp1);
            return response;
        } else {
            List<InvoicePigDetail> temp = new ArrayList<>();
            for (InvoicesPig ip :
                    invoicesPigList) {
                temp.addAll(invoicePigDetailRepository.findByInvoiceAndDelFlag(ip,false));
            }
            response.setInvoicesPig(invoicesPigList);
            response.setInvoicePigDetail(temp);
            return response;
        }

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
