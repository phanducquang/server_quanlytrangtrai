package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.DTO.*;
import tk.giaiphapchannuoi.server.model.*;
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
    PigsService pigsService;

    @Autowired
    InvoicesPigService invoicesPigService;

    @Autowired
    BirthsService birthsService;

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
            } else if (ipd.getInvoice().getInvoiceType().equals("sale")){
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
            } else if (ipd.getInvoice().getInvoiceType().equals("sale")){
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
            } else if (invoicePigDetail.get().getInvoice().getInvoiceType().equals("sale")){
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

        //Chuyen sang trang thai cho ban khi hoa don la "xuat ban"
        if (pigsInvoicePigDetailDTORequest.getInvoicesPig().getInvoiceType().equals("sale")){
            Status status = statusRepository.findByCodeAndPreviousStatusAndDelFlag(8,pigsInvoicePigDetailDTORequest.getPigs().getStatus().getCode(),false).get();
            pigsInvoicePigDetailDTORequest.getPigs().setStatus(status);
        }
        Pigs pigs = pigsRepository.save(pigsInvoicePigDetailDTORequest.getPigs());
        InvoicePigDetail temp = new InvoicePigDetail();
        temp.setDelFlag(false);
        temp.setInvoice(pigsInvoicePigDetailDTORequest.getInvoicesPig());
        temp.setObjectId(pigs.getId());

        InvoicePigDetail invoicePigDetail = save(temp);
        InvoicesPig invoicesPig = invoicesPigRepository.findByIdAndDelFlag(pigsInvoicePigDetailDTORequest.getInvoicesPig().getId(),false).get();

        //Cap nhat so luong heo
        if(invoicesPig.getQuantity()!=null){
            invoicesPig.setQuantity(invoicesPig.getQuantity() + 1);
        }else{
            invoicesPig.setQuantity(1);
        }

        //Cap nhat theo nghiep vu HEO CON
        if (pigs.getStatus().getCode().equals(12)){
            Births births = birthsService.findbyid(pigs.getBirthId());
            if (births.getBorning() != null){
                births.setBorning( births.getBorning() + 1);
            }else {
                births.setBorning(1);
            }

            if (births.getSelected() != null){
                births.setSelected( births.getSelected() + 1);
            }else {
                births.setSelected(1);
            }
            birthsService.update(births);
        }

        //Origin_Weight: khoi luong dong, thay doi theo vong doi heo.
        //Receive_Weight: Khoi luong heo luc nhan(so lieu tu nha cung cap)
        //Truong hop nhap heo ngoai he thong tinh heo khoi luong nhap
        if (!pigsInvoicePigDetailDTORequest.getInvoicesPig().getInvoiceType().equals("external-import")) {
            //Cap nhat tong trong luong
            if(invoicesPig.getTotalWeight()!=null){
                invoicesPig.setTotalWeight(invoicesPig.getTotalWeight() + pigs.getOriginWeight());
            }else{
                invoicesPig.setTotalWeight(pigs.getOriginWeight());
            }
        }

        //Cap nhat tong gia neu la ban
        if (pigsInvoicePigDetailDTORequest.getInvoicesPig().getInvoiceType().equals("sale")){
            if(invoicesPig.getTotalPrice()!=null){
                invoicesPig.setTotalPrice(invoicesPig.getTotalPrice() + pigs.getOriginWeight()*invoicesPig.getUnitPrice());
            }else{
                invoicesPig.setTotalWeight(pigs.getOriginWeight()*invoicesPig.getUnitPrice());
            }
        } else if (pigsInvoicePigDetailDTORequest.getInvoicesPig().getInvoiceType().equals("external-import")){
            //Cap nhat tong trong luong
            if(invoicesPig.getTotalWeight()!=null){
                invoicesPig.setTotalWeight(invoicesPig.getTotalWeight() + pigs.getReceiveWeight());
            }else{
                invoicesPig.setTotalWeight(pigs.getReceiveWeight());
            }
            //Cap nhat tong gia neu la nhap ngoai he thong
            if(invoicesPig.getTotalPrice()!=null){
                invoicesPig.setTotalPrice(invoicesPig.getTotalPrice() + pigs.getReceiveWeight()*invoicesPig.getUnitPrice());
            }else{
                invoicesPig.setTotalWeight(pigs.getReceiveWeight()*invoicesPig.getUnitPrice());
            }
        }
        invoicePigDetail.setInvoice(invoicesPigRepository.save(invoicesPig));
        PigsDTO pigsDTO = pigsDTORepository.findByIdAndDelFlag(pigs.getId(),false).get();
//                new PigsDTO(pigs.getId(),pigs.getPigCode(),pigs.getHouse().getId(),pigs.getRound().getId(),pigs.getBirthId(),pigs.getBreed().getId(),pigs.getGender(),pigs.getBirthday(),pigs.getBorn_weight(),pigs.getBornStatus(),pigs.getOriginId(),pigs.getOriginFather(), pigs.getOriginMother(),pigs.getOriginWeight(),pigs.getReceiveWeight(), pigs.getHealthPoint(),pigs.getFoot().getId(),pigs.getFunctionUdder(),pigs.getTotalUdder(),pigs.getGentialType().getId(), pigs.getDescription(),pigs.getFcr(),pigs.getAdg(),pigs.getBf(),pigs.getFilet(),pigs.getLongBack(),pigs.getLongBody(),pigs.getIndex(),pigs.getParities(),pigs.getImages(),pigs.getHealthStatus().getId(),pigs.getBreedingType(),pigs.getBreedStatus(),pigs.getPregnancyStatus().getId(),pigs.getPoint_review(),pigs.getStatus().getId(),pigs.getPriceCode().getId(),pigs.getOverviewStatus(),pigs.getDelFlag());
        PigsInvoicePigDetailDTOResponse response = new PigsInvoicePigDetailDTOResponse(pigsDTO,invoicePigDetail);
        return response;
    }

    //Cap nhat pig khi da them pig vao invoice_pig
    @Transactional
    public PigsInvoicePigDetailDTOResponse updatePigInInvoicePig(PigsInvoicePigDetailDTORequest pigsInvoicePigDetailDTORequest){
        Integer farmId = usersService.getFarmId();
        Pigs pig = pigsInvoicePigDetailDTORequest.getPigs();
        PigsDTO pig_old = new PigsDTO();
        pig_old.convertTo(pigsService.findbyid(pig.getId()).get());
        InvoicesPig invoicesPig = pigsInvoicePigDetailDTORequest.getInvoicesPig();
        PigsInvoicePigDetailDTOResponse pigsInvoicePigDetailDTOResponse = new PigsInvoicePigDetailDTOResponse();
        pigsService.update(pig);
        PigsDTO pigsDTO = pigsDTORepository.findByIdAndDelFlag(pig.getId(),false).get();
        pigsInvoicePigDetailDTOResponse.setPigs(pigsDTO);
        //nhap ngoai he thong thi dung receive_weight de tinh, nguoc lai dung origin_weight de tinh
        if (!pigsInvoicePigDetailDTORequest.getInvoicesPig().getInvoiceType().equals("external-import")){
            invoicesPig.setTotalWeight(invoicesPig.getTotalWeight() - pig_old.getOriginWeight() + pig.getOriginWeight());
        } else if (pigsInvoicePigDetailDTORequest.getInvoicesPig().getInvoiceType().equals("external-import")){
            invoicesPig.setTotalWeight(invoicesPig.getTotalWeight() - pig_old.getReceiveWeight() + pig.getReceiveWeight());
            invoicesPig.setTotalPrice(invoicesPig.getTotalPrice() - pig_old.getReceiveWeight()*invoicesPig.getUnitPrice() + pig.getReceiveWeight()*invoicesPig.getUnitPrice());
        }
        //Cap nhat lai gia neu hoa don dung de ban
        if (pigsInvoicePigDetailDTORequest.getInvoicesPig().getInvoiceType().equals("sale")){
            invoicesPig.setTotalPrice(invoicesPig.getTotalPrice() - pig_old.getOriginWeight()*invoicesPig.getUnitPrice() + pig.getOriginWeight()*invoicesPig.getUnitPrice());
        }
        pigsInvoicePigDetailDTOResponse.setInvoicesPig(invoicesPigService.update(invoicesPig));
        return pigsInvoicePigDetailDTOResponse;
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

                //nhap ngoai he thong thi dung receive_weight de tinh, nguoc lai dung origin_weight de tinh
                if (!invoicesPig.getInvoiceType().equals("external-import")){
                    invoicesPig.setTotalWeight(invoicesPig.getTotalWeight() - pig.getOriginWeight());
                } else if (invoicesPig.getInvoiceType().equals("external-import")){
                    invoicesPig.setTotalWeight(invoicesPig.getTotalWeight() - pig.getReceiveWeight());
                    invoicesPig.setTotalPrice(invoicesPig.getTotalPrice() - pig.getReceiveWeight()*invoicesPig.getUnitPrice());
                }
                //Cap nhat lai gia neu hoa don dung de ban
                if (invoicesPig.getInvoiceType().equals("sale")){
                    invoicesPig.setTotalPrice(invoicesPig.getTotalPrice() - pig.getOriginWeight()*invoicesPig.getUnitPrice());
                }
                invoicesPig.setQuantity(invoicesPig.getQuantity() - 1);
//                //gan Total_Weight = Total_Weight - receive_weight cua heo xoa
//                invoicesPig.setTotalWeight(invoicesPig.getTotalWeight() - pig.getReceiveWeight());
//                invoicesPig.setTotalPrice(invoicesPig.getTotalPrice() + pig.getReceiveWeight()*invoicesPig.getUnitPrice());
                //Xoa heo
                pig.setDelFlag(true);
                pigsRepository.save(pig);
                if(invoicePigDetailRepository.save(invoicePigDetail) != null){
                    invoicesPigRepository.save(invoicesPig);
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

                //Cap nhat lai invoicePig khi xao heo khoi invoice
                InvoicesPig invoicesPig = invoicesPigRepository.findByIdAndDelFlag(invoicePigDetail.getInvoice().getId(),false).get();
                //nhap ngoai he thong thi dung receive_weight de tinh, nguoc lai dung origin_weight de tinh
                if (!invoicesPig.getInvoiceType().equals("external-import")){
                    invoicesPig.setTotalWeight(invoicesPig.getTotalWeight() - pig.getOriginWeight());
                } else if (invoicesPig.getInvoiceType().equals("external-import")){
                    invoicesPig.setTotalWeight(invoicesPig.getTotalWeight() - pig.getReceiveWeight());
                    invoicesPig.setTotalPrice(invoicesPig.getTotalPrice() - pig.getReceiveWeight()*invoicesPig.getUnitPrice());
                }
                //Cap nhat lai gia neu hoa don dung de ban
                if (invoicesPig.getInvoiceType().equals("sale")){
                    invoicesPig.setTotalPrice(invoicesPig.getTotalPrice() - pig.getOriginWeight()*invoicesPig.getUnitPrice());
                }
                invoicesPig.setQuantity(invoicesPig.getQuantity() - 1);
                //Cap nhat status ve pre_status
                Status status = statusRepository.findByCodeAndPreviousStatusAndDelFlag(pig.getStatus().getPreviousStatus(), 0,false).get();
                pig.setStatus(status);
                pigsRepository.save(pig);
                if(invoicePigDetailRepository.save(invoicePigDetail) != null){
                    invoicesPigService.update(invoicesPig);
                    return true;
                }
            }
        }
        return false;
    }
}
