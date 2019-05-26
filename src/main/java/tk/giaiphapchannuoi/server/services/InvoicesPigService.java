package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.DTO.InvoicesPigInvoicePigDetailDTOResponse;
import tk.giaiphapchannuoi.server.DTO.PigsDTO;
import tk.giaiphapchannuoi.server.DTO.PigsInvoicePigDTORequest;
import tk.giaiphapchannuoi.server.DTO.PigsInvoicePigDTOResponse;
import tk.giaiphapchannuoi.server.model.InvoicePigDetail;
import tk.giaiphapchannuoi.server.model.InvoicesPig;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.repository.InvoicePigDetailRepository;
import tk.giaiphapchannuoi.server.repository.InvoicesPigRepository;
import tk.giaiphapchannuoi.server.repository.PigsRepository;

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

    @Autowired
    PigsRepository pigsRepository;

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
            List<Pigs> pigs = new ArrayList<>();
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

            for (InvoicePigDetail ipd :
                    temp1) {
                pigs.add(pigsRepository.findByIdAndDelFlag(ipd.getObjectId(),false).get());
            }

            response.setInvoicesPig(temp);
            response.setInvoicePigDetail(temp1);
            response.setPigs(pigs);
            return response;
        } else {
            List<InvoicePigDetail> temp = new ArrayList<>();
            List<Pigs> pigs = new ArrayList<>();
            for (InvoicesPig ip :
                    invoicesPigList) {
                temp.addAll(invoicePigDetailRepository.findByInvoiceAndDelFlag(ip,false));
            }

            for (InvoicePigDetail ipd :
                    temp) {
                pigs.add(pigsRepository.findByIdAndDelFlag(ipd.getObjectId(),false).get());
            }
            response.setInvoicesPig(invoicesPigList);
            response.setInvoicePigDetail(temp);
            response.setPigs(pigs);
            return response;
        }

    }

    @Transactional
    public PigsInvoicePigDTOResponse savecustom(PigsInvoicePigDTORequest pigsInvoicePigDTORequest){
        PigsInvoicePigDTOResponse response = new PigsInvoicePigDTOResponse();
        List<Pigs> pigsList = pigsInvoicePigDTORequest.getPigsList();
        List<PigsDTO> tempPigs = new ArrayList<>();
        List<InvoicePigDetail> tempInvoicePigDetails = new ArrayList<>();
        InvoicesPig tempInvoicePig = invoicePigRepository.save(pigsInvoicePigDTORequest.getInvoicesPig());
        for (Pigs p :
                pigsList) {
            Pigs temp = pigsRepository.save(p);
            PigsDTO pigsDTO = new PigsDTO(temp.getId(),temp.getPigCode(),temp.getHouse().getId(),temp.getRound().getId(),temp.getBirthId(),temp.getBreed().getId(),temp.getGender(),temp.getBirthday(),temp.getBorn_weight(),temp.getBornStatus(),temp.getOriginId(),temp.getOriginFather(), temp.getOriginMother(),temp.getOriginWeight(),temp.getReceiveWeight(), temp.getHealthPoint(),temp.getFoot().getId(),temp.getFunctionUdder(),temp.getTotalUdder(),temp.getGentialType().getId(), temp.getDescription(),temp.getFcr(),temp.getAdg(),temp.getBf(),temp.getFilet(),temp.getLongBack(),temp.getLongBody(),temp.getIndex(),temp.getParities(),temp.getImages(),temp.getHealthStatus().getId(),temp.getBreedingType(),temp.getBreedStatus(),temp.getPregnancyStatus().getId(),temp.getPoint_review(),temp.getStatus().getId(),temp.getPriceCode().getId(),temp.getOverviewStatus(),temp.getDelFlag());
            tempPigs.add(pigsDTO);
            InvoicePigDetail tempDetail = new InvoicePigDetail();
            tempDetail.setObjectId(p.getId());
            tempDetail.setInvoice(tempInvoicePig);
            tempDetail.setDelFlag(false);
            tempInvoicePigDetails.add(invoicePigDetailRepository.save(tempDetail));
        }
        invoicePigRepository.save(pigsInvoicePigDTORequest.getInvoicesPigUpdate());
        response.setPigsList(tempPigs);
        response.setInvoicesPig(tempInvoicePig);
        response.setInvoicePigDetailList(tempInvoicePigDetails);
        return response;
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
