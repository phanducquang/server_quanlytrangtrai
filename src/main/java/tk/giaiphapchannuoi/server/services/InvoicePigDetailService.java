package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.DTO.Pigs1DTO;
import tk.giaiphapchannuoi.server.DTO.PigsDTO;
import tk.giaiphapchannuoi.server.DTO.PigsInvoicePigDetailDTORequest;
import tk.giaiphapchannuoi.server.DTO.PigsInvoicePigDetailDTOResponse;
import tk.giaiphapchannuoi.server.model.InvoicePigDetail;
import tk.giaiphapchannuoi.server.model.InvoicesPig;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.model.Status;
import tk.giaiphapchannuoi.server.repository.*;

import java.util.ArrayList;
import java.util.Collections;
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

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    Pigs1DTORepository pigs1DTORepository;

    @Autowired
    PigsDTORepository pigsDTORepository;

    @Autowired
    UsersService usersService;

    public List<InvoicePigDetail> findall(){
        Integer farmId = usersService.getFarmId();
        List<InvoicePigDetail> temp = invoicePigDetailRepository.findAllByDelFlag(false);
        if (farmId.equals(0)){
            return temp;
        }
        List<InvoicePigDetail> invoicePigDetailList = new ArrayList<>();
        for (InvoicePigDetail ipd :
                temp) {
            if(ipd.getInvoice().getInvoiceType().equals("external-import")){
                if (ipd.getInvoice().getDestinationId().equals(farmId)){
                    invoicePigDetailList.add(ipd);
                }
            } else if(ipd.getInvoice().getInvoiceType().equals("internal-export")){
                if (ipd.getInvoice().getSourceId().equals(farmId)){
                    invoicePigDetailList.add(ipd);
                }
            } else if (ipd.getInvoice().getInvoiceType().equals("internal-import")){
                if (ipd.getInvoice().getDestinationId().equals(farmId)){
                    invoicePigDetailList.add(ipd);
                }
            } else if (ipd.getInvoice().getInvoiceType().equals("external-export")){
                if (ipd.getInvoice().getSourceId().equals(farmId)){
                    invoicePigDetailList.add(ipd);
                }
            } else if (ipd.getInvoice().getInvoiceType().equals("root")){
                if (ipd.getInvoice().getSourceId().equals(farmId)){
                    invoicePigDetailList.add(ipd);
                }
            }
        }
        return invoicePigDetailList;
    }

    public List<InvoicePigDetail> findbyinvoice(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<InvoicesPig> invoicesPig = invoicesPigRepository.findByIdAndDelFlag(id,false);
        List<InvoicePigDetail> temp = invoicesPig.map(ip -> invoicePigDetailRepository.findByInvoiceAndDelFlag(ip, false)).orElse(Collections.emptyList());
        if (farmId.equals(0)){
            return temp;
        }
        List<InvoicePigDetail> invoicePigDetailList = new ArrayList<>();
        for (InvoicePigDetail ipd :
                temp) {
            if(ipd.getInvoice().getInvoiceType().equals("external-import")){
                if (ipd.getInvoice().getDestinationId().equals(farmId)){
                    return temp;// Tra ve "temp" do cung invoice nen tat ca data lay duoc deu cung farm => chi xet 1 dong dau tien
                }
            } else if(ipd.getInvoice().getInvoiceType().equals("internal-export")){
                if (ipd.getInvoice().getSourceId().equals(farmId)){
                    return temp;
                }
            } else if (ipd.getInvoice().getInvoiceType().equals("internal-import")){
                if (ipd.getInvoice().getDestinationId().equals(farmId)){
                    return temp;
                }
            } else if (ipd.getInvoice().getInvoiceType().equals("external-export")){
                if (ipd.getInvoice().getSourceId().equals(farmId)){
                    return temp;
                }
            } else if (ipd.getInvoice().getInvoiceType().equals("root")){
                if (ipd.getInvoice().getSourceId().equals(farmId)){
                    return temp;
                }
            }
        }
        return Collections.emptyList();
    }

    public Optional<InvoicePigDetail> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<InvoicePigDetail> invoicePigDetail = invoicePigDetailRepository.findByIdAndDelFlag(id,false);
        if (invoicePigDetail.isPresent()){
            if (farmId.equals(0)){
                return invoicePigDetail;
            } else if(invoicePigDetail.get().getInvoice().getInvoiceType().equals("external-import")){
                if (invoicePigDetail.get().getInvoice().getDestinationId().equals(farmId)){
                    return invoicePigDetail;
                }
            } else if(invoicePigDetail.get().getInvoice().getInvoiceType().equals("internal-export")){
                if (invoicePigDetail.get().getInvoice().getSourceId().equals(farmId)){
                    return invoicePigDetail;
                }
            } else if (invoicePigDetail.get().getInvoice().getInvoiceType().equals("internal-import")){
                if (invoicePigDetail.get().getInvoice().getDestinationId().equals(farmId)){
                    return invoicePigDetail;
                }
            } else if (invoicePigDetail.get().getInvoice().getInvoiceType().equals("external-export")){
                if (invoicePigDetail.get().getInvoice().getSourceId().equals(farmId)){
                    return invoicePigDetail;
                }
            } else if (invoicePigDetail.get().getInvoice().getInvoiceType().equals("root")){
                if (invoicePigDetail.get().getInvoice().getSourceId().equals(farmId)){
                    return invoicePigDetail;
                }
            }
        }
        return Optional.empty();
    }

    public InvoicePigDetail save(InvoicePigDetail invoicePigDetail){
        invoicePigDetail.setDelFlag(false);
        return invoicePigDetailRepository.save(invoicePigDetail);
    }

    //Them invoice pig detail va pig (nhap ngoai he thong) hoac them invoice pig detail va cap nhat pig (xuat ban, xuat heo trong he thong)
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
            invoicesPig.setTotalWeight(pigs.getOriginWeight());
        }
        invoicesPigRepository.save(invoicesPig);
        PigsDTO pigsDTO = pigsDTORepository.findByIdAndDelFlag(pigs.getId(),false).get();
//                new PigsDTO(pigs.getId(),pigs.getPigCode(),pigs.getHouse().getId(),pigs.getRound().getId(),pigs.getBirthId(),pigs.getBreed().getId(),pigs.getGender(),pigs.getBirthday(),pigs.getBorn_weight(),pigs.getBornStatus(),pigs.getOriginId(),pigs.getOriginFather(), pigs.getOriginMother(),pigs.getOriginWeight(),pigs.getReceiveWeight(), pigs.getHealthPoint(),pigs.getFoot().getId(),pigs.getFunctionUdder(),pigs.getTotalUdder(),pigs.getGentialType().getId(), pigs.getDescription(),pigs.getFcr(),pigs.getAdg(),pigs.getBf(),pigs.getFilet(),pigs.getLongBack(),pigs.getLongBody(),pigs.getIndex(),pigs.getParities(),pigs.getImages(),pigs.getHealthStatus().getId(),pigs.getBreedingType(),pigs.getBreedStatus(),pigs.getPregnancyStatus().getId(),pigs.getPoint_review(),pigs.getStatus().getId(),pigs.getPriceCode().getId(),pigs.getOverviewStatus(),pigs.getDelFlag());
        PigsInvoicePigDetailDTOResponse response = new PigsInvoicePigDetailDTOResponse(pigsDTO,invoicePigDetail);
        return response;
    }

    public InvoicePigDetail update(InvoicePigDetail invoicePigDetail){
        Integer farmId = usersService.getFarmId();
        Optional<Pigs1DTO> pig = pigs1DTORepository.findByIdAndDelFlag(invoicePigDetail.getObjectId(),false);
        if (pig.isPresent()){
            if (farmId.equals(0) || pig.get().getHouse().getSection().getFarm().getId().equals(farmId)){
                return invoicePigDetailRepository.save(invoicePigDetail);
            }
        }
        return null;
    }

    @Transactional
    public Boolean delete(InvoicePigDetail invoicePigDetail){
        Integer farmId = usersService.getFarmId();
        invoicePigDetail.setDelFlag(true);
        //Lay thong tin cua pig
        Optional<Pigs> temp_pig = pigsRepository.findByIdAndDelFlag(invoicePigDetail.getObjectId(),false);
        if (temp_pig.isPresent()){
            Pigs pig = temp_pig.get();
            if (farmId.equals(0) || pig.getHouse().getSection().getFarm().getId().equals(farmId)){
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
            }
        }
        return false;
    }

    @Transactional
    public Boolean deleteonlyinvoicedetail(InvoicePigDetail invoicePigDetail){
        Integer farmId = usersService.getFarmId();
        invoicePigDetail.setDelFlag(true);
        //Lay thong tin cua pig
        Optional<Pigs> temp_pig = pigsRepository.findByIdAndDelFlag(invoicePigDetail.getObjectId(),false);
        if (temp_pig.isPresent()) {
            Pigs pig = temp_pig.get();
            if (farmId.equals(0) || pig.getHouse().getSection().getFarm().getId().equals(farmId)) {
                //Cap nhat status ve pre_status
                Status status = statusRepository.findByCodeAndPreviousStatusAndDelFlag(pig.getStatus().getPreviousStatus(), 0,false).get();
                pig.setStatus(status);
                pigsRepository.save(pig);
                if(invoicePigDetailRepository.save(invoicePigDetail) != null){
                    return true;
                }
            }
        }
        return false;
    }
}
