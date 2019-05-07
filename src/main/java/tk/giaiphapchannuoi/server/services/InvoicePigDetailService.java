package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.DTO.PigsDTO;
import tk.giaiphapchannuoi.server.DTO.PigsInvoicePigDetailDTORequest;
import tk.giaiphapchannuoi.server.DTO.PigsInvoicePigDetailDTOResponse;
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
    public PigsInvoicePigDetailDTOResponse savePigsInvoicePigDetail(PigsInvoicePigDetailDTORequest pigsInvoicePigDetailDTORequest){
        pigsInvoicePigDetailDTORequest.getPigs().setDelFlag(false);
        Pigs pigs = pigsRepository.save(pigsInvoicePigDetailDTORequest.getPigs());
        InvoicePigDetail temp = new InvoicePigDetail();
        temp.setDelFlag(false);
        temp.setInvoice(pigsInvoicePigDetailDTORequest.getInvoicesPig());
        temp.setObjectId(pigs.getId());

        InvoicePigDetail invoicePigDetail = save(temp);
        InvoicesPig invoicesPig = invoicesPigRepository.findByIdAndDelFlag(pigsInvoicePigDetailDTORequest.getInvoicesPig().getId(),false).get();

        if(invoicesPig.getQuantity()!=null){
            invoicesPig.setQuantity(invoicesPig.getQuantity() + 1);
        }else{
            invoicesPig.setQuantity(1);
        }

        if(invoicesPig.getTotalWeight()!=null){
            invoicesPig.setTotalWeight(invoicesPig.getTotalWeight() + pigs.getOriginWeight());
        }else{
            invoicesPig.setTotalWeight(1f);
        }

        invoicesPigRepository.save(invoicesPig);
        PigsDTO pigsDTO = new PigsDTO(pigs.getId(),pigs.getPigCode(),pigs.getHouse().getId(),pigs.getRound().getId(),pigs.getBreed().getId(),pigs.getGender(),pigs.getBirthday(),pigs.getBorn_weight(),pigs.getBornStatus(),pigs.getOriginId(),pigs.getOriginFather(), pigs.getOriginMother(),pigs.getOriginWeight(),pigs.getReceiveWeight(), pigs.getHealthPoint(),pigs.getFoot().getId(),pigs.getFunctionUdder(),pigs.getTotalUdder(),pigs.getGentialType().getId(), pigs.getDescription(),pigs.getFcr(),pigs.getAdg(),pigs.getBf(),pigs.getFilet(),pigs.getLongBack(),pigs.getLongBody(),pigs.getIndex(),pigs.getParities(),pigs.getImages(),pigs.getHealthStatus().getId(),pigs.getBreedingType(),pigs.getBreedStatus(),pigs.getPregnancyStatus().getId(),pigs.getPoint_review(),pigs.getStatus().getId(),pigs.getPriceCode().getId(),pigs.getOverviewStatus(),pigs.getDelFlag());
        PigsInvoicePigDetailDTOResponse response = new PigsInvoicePigDetailDTOResponse(pigsDTO,invoicePigDetail);
        return response;
    }

    public InvoicePigDetail update(InvoicePigDetail invoicePigDetail){
        return invoicePigDetailRepository.save(invoicePigDetail);
    }

    @Transactional
    public Boolean delete(InvoicePigDetail invoicePigDetail){
        invoicePigDetail.setDelFlag(true);
        //Lay thong tin cua pig
        Pigs pig = pigsRepository.findByIdAndDelFlag(invoicePigDetail.getObjectId(),false).get();
        //Thuc hien duyet tim invoice lien quan den pig de thay doi total_weight
        InvoicesPig invoicesPig = invoicesPigRepository.findByIdAndDelFlag(invoicePigDetail.getInvoice().getId(),false).get();
        //gan Total_Weight = Total_Weight - receive_weight cua heo xoa
        invoicesPig.setTotalWeight(invoicesPig.getTotalWeight() - pig.getReceiveWeight());
        invoicesPigRepository.save(invoicesPig);
        //Xoa heo
        pig.setDelFlag(true);
        pigsRepository.save(pig);
        if(invoicePigDetailRepository.save(invoicePigDetail) != null){
            return true;
        }
        return false;
    }
}
