package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.DTO.PigsDTO;
import tk.giaiphapchannuoi.server.model.InvoicePigDetail;
import tk.giaiphapchannuoi.server.model.InvoicesPig;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.repository.InvoicePigDetailRepository;
import tk.giaiphapchannuoi.server.repository.InvoicesPigRepository;
import tk.giaiphapchannuoi.server.repository.PigsDTORepository;
import tk.giaiphapchannuoi.server.repository.PigsRepository;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("Duplicates")
@Service
@Transactional
public class PigsService {

    @Autowired
    PigsRepository pigsRepository;

    @Autowired
    PigsDTORepository pigsDTORepository;

    @Autowired
    InvoicesPigRepository invoicesPigRepository;

    @Autowired
    InvoicePigDetailRepository invoicePigDetailRepository;

    public List<PigsDTO> findall(){
        return pigsDTORepository.findAllByDelFlag(false);
    }

    public Optional<Pigs> findbyid(Integer id){
        return pigsRepository.findByIdAndDelFlag(id,false);
    }

    public Pigs save(Pigs pig){
        pig.setDelFlag(false);
        return pigsRepository.save(pig);
    }

    @Transactional
    public Pigs update(Pigs pig){
        float receiveWeightOld = pigsRepository.findByIdAndDelFlag(pig.getId(),false).get().getReceiveWeight();//Lay thong tin pig truoc khi cap nhat
        Pigs temp = new Pigs();
                temp = pigsRepository.save(pig);//Lay thong tin Pig sau khi cap nhat
        if(receiveWeightOld != temp.getReceiveWeight()){
            List<InvoicePigDetail> invoicePigDetailList = invoicePigDetailRepository.findByObjectIdAndDelFlag(temp.getId(), false);
            //Thuc hien duyet tat ca cac invoice lien quan den pig de thay doi total_weight
            for (InvoicePigDetail invoice :
                    invoicePigDetailList) {
                InvoicesPig invoicesPig = invoicesPigRepository.findByIdAndDelFlag(invoice.getInvoice().getId(),false).get();
                //gan Total_Weight = Total_Weight - (receive_weight cua heo luc chua chinh sua) + (receive_weight cua heo luc da chinh sua)
                invoicesPig.setTotalWeight(invoicesPig.getTotalWeight() - receiveWeightOld + temp.getReceiveWeight());
                invoicesPigRepository.save(invoicesPig);
            }
        }
        return temp;
    }

    @Transactional
    public Boolean delete(Pigs pig){
        pig.setDelFlag(true);

        List<InvoicePigDetail> invoicePigDetailList = invoicePigDetailRepository.findByObjectIdAndDelFlag(pig.getId(), false);
        //Thuc hien duyet tat ca cac invoice lien quan den pig de thay doi total_weight
        for (InvoicePigDetail invoice :
                invoicePigDetailList) {
            InvoicesPig invoicesPig = invoicesPigRepository.findByIdAndDelFlag(invoice.getInvoice().getId(),false).get();
            invoicesPig.setQuantity(invoicesPig.getQuantity() - 1);

            //gan Total_Weight = Total_Weight - (receive_weight cua heo can xoa)
            invoicesPig.setTotalWeight(invoicesPig.getTotalWeight() - pig.getReceiveWeight());
            invoicesPigRepository.save(invoicesPig);
        }

        if(pigsRepository.save(pig) != null){
            return true;
        }
        return false;
    }
}
