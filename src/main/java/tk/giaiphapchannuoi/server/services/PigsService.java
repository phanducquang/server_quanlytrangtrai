package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.DTO.Pigs1DTO;
import tk.giaiphapchannuoi.server.DTO.PigsDTO;
import tk.giaiphapchannuoi.server.model.*;
import tk.giaiphapchannuoi.server.repository.*;

import java.util.ArrayList;
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
    Pigs1DTORepository pigs1DTORepository;

    @Autowired
    InvoicesPigRepository invoicesPigRepository;

    @Autowired
    InvoicePigDetailRepository invoicePigDetailRepository;

    @Autowired
    FarmsRepository farmsRepository;

    @Autowired
    CagesRepository cagesRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    UsersService usersService;

    public List<PigsDTO> findall(){
        Integer farmId = usersService.getFarmId();
        if (farmId == 0){
            return pigsDTORepository.findAllByDelFlag(false);
        }
        List<Pigs1DTO> pigs1DTOList = pigs1DTORepository.findAllByDelFlag(false);
        List<PigsDTO> pigsDTOList = new ArrayList<>();
        for (Pigs1DTO p :
                pigs1DTOList) {
            if (p.getHouse().getSection().getFarm().getId().equals(farmId)){
                PigsDTO pigsDTO = new PigsDTO(p.getId(),p.getPigCode(),p.getHouse().getId(),p.getRoundId(),p.getBirthId(),p.getBreedId(),p.getGender(),p.getBirthday(),p.getBorn_weight(),p.getBornStatus(),p.getOriginId(),p.getOriginFather(), p.getOriginMother(),p.getOriginWeight(),p.getReceiveWeight(), p.getHealthPoint(),p.getFootTypeId(),p.getFunctionUdder(),p.getTotalUdder(),p.getGentialTypeId(), p.getDescription(),p.getFcr(),p.getAdg(),p.getBf(),p.getFilet(),p.getLongBack(),p.getLongBody(),p.getIndex(),p.getParities(),p.getImages(),p.getHealthStatusId(),p.getBreedingType(),p.getBreedStatus(),p.getPregnancyStatusId(),p.getPoint_review(),p.getStatusId(),p.getPriceCodeId(),p.getOverviewStatus(),p.getDelFlag());
                pigsDTOList.add(pigsDTO);
            }
        }
        return pigsDTOList;
    }

    public Optional<Pigs> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        if (farmId == 0){
            return pigsRepository.findByIdAndDelFlag(id,false);
        }
        Optional<Pigs> pigs = pigsRepository.findByIdAndDelFlag(id,false);
        if (pigs.get().getHouse().getSection().getFarm().getId().equals(farmId)){
            return pigs;
        }
        return Optional.empty();
    }

    public List<Pigs> findbyhealthstatus(){
        Integer farmId = usersService.getFarmId();
        List<Pigs> temp = pigsRepository.findAllByDelFlag(false);
        if (farmId.equals(0)){
            return temp;
        }
        List<Pigs> pigs = new ArrayList<>();
        for (Pigs p :
                temp) {
            if (p.getHealthStatus().getId() != 1 && p.getHealthStatus().getId() != 0 && p.getHouse().getSection().getFarm().getId().equals(farmId)){
                pigs.add(p);
            }
        }
        return pigs;
    }

    public Pigs save(Pigs pig){
        Integer farmId = usersService.getFarmId();
        //Cage bằng với house
        Optional<Cages> cage = cagesRepository.findByIdAndDelFlag(pig.getHouse().getId(),false);
        Integer farmIdFromPig = cage.map(c -> c.getSection().getFarm().getId()).orElse(null);
        if (farmId.equals(0) || farmId.equals(farmIdFromPig)){
            pig.setDelFlag(false);
            return pigsRepository.save(pig);
        }
        return null;
    }

    @Transactional
    public Pigs update(Pigs pig){
        Integer farmId = usersService.getFarmId();
        //Cage bằng với house
        Optional<Cages> cage = cagesRepository.findByIdAndDelFlag(pig.getHouse().getId(),false);
        Integer farmIdFromPig = cage.map(c -> c.getSection().getFarm().getId()).orElse(null);
        if (farmId.equals(0) || farmId.equals(farmIdFromPig)){
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
        return null;
    }

    @Transactional
    public List<Pigs> updatestatus(List<Pigs> pigsList, Integer statusCode, Integer preStatusCode){
        List<Pigs> temp = new ArrayList();
        Status status = statusRepository.findByCodeAndPreviousStatusAndDelFlag(statusCode,preStatusCode,false).get();
        for (Pigs p :
                pigsList) {
            p.setStatus(status);
            temp.add(pigsRepository.save(p));
        }
        return temp;
    }

    @Transactional
    public Boolean delete(Pigs pig){
        Integer farmId = usersService.getFarmId();
        //Cage bằng với house
        Optional<Cages> cage = cagesRepository.findByIdAndDelFlag(pig.getHouse().getId(),false);
        Integer farmIdFromPig = cage.map(c -> c.getSection().getFarm().getId()).orElse(null);
        if (farmId.equals(0) || farmId.equals(farmIdFromPig)){
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
        return false;
    }
}
