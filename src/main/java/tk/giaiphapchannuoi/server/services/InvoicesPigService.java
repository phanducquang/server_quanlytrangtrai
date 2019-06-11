package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.DTO.InvoicesPigInvoicePigDetailDTOResponse;
import tk.giaiphapchannuoi.server.DTO.PigsDTO;
import tk.giaiphapchannuoi.server.DTO.PigsInvoicePigDTORequest;
import tk.giaiphapchannuoi.server.DTO.PigsInvoicePigDTOResponse;
import tk.giaiphapchannuoi.server.model.*;
import tk.giaiphapchannuoi.server.repository.EmployeesRepository;
import tk.giaiphapchannuoi.server.repository.InvoicePigDetailRepository;
import tk.giaiphapchannuoi.server.repository.InvoicesPigRepository;
import tk.giaiphapchannuoi.server.repository.PigsRepository;
import tk.giaiphapchannuoi.server.security.JwtAuthenticationFilter;

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

    @Autowired
    EmployeesRepository employeesRepository;

    public List<InvoicesPig> findall(){
        Integer farmId = usersService.getFarmId();
        List<InvoicesPig> temp = invoicePigRepository.findAllByDelFlag(false);
        if (farmId.equals(0)){
            return temp;
        }
        List<InvoicesPig> invoicesPigList = new ArrayList<>();
        for (InvoicesPig ip :
                temp) {
            if(ip.getInvoiceType().equals("external-import")){
                if (ip.getDestinationId().equals(farmId)){
                    invoicesPigList.add(ip);
                }
            } else if(ip.getInvoiceType().equals("internal-export")){
                if (ip.getSourceId().equals(farmId)){
                    invoicesPigList.add(ip);
                }
            } else if (ip.getInvoiceType().equals("internal-import")){
                if (ip.getDestinationId().equals(farmId)){
                    invoicesPigList.add(ip);
                }
            } else if (ip.getInvoiceType().equals("sale")){
                if (ip.getSourceId().equals(farmId)){
                    invoicesPigList.add(ip);
                }
            } else if (ip.getInvoiceType().equals("root")){
                if (ip.getSourceId().equals(farmId)){
                    invoicesPigList.add(ip);
                }
            }
        }
        return invoicesPigList;
    }

    public Optional<InvoicesPig> findbyid(Integer id){

        Optional<InvoicesPig> invoicesPig = invoicePigRepository.findByIdAndDelFlag(id,false);
        if (invoicesPig.isPresent()){
            Integer farmId = usersService.getFarmId();
            InvoicesPig ip = invoicesPig.get();
            if (farmId.equals(0)){
                return invoicesPig;
            }
            if(ip.getInvoiceType().equals("external-import")){
                if (ip.getDestinationId().equals(farmId)){
                    return invoicesPig;
                }
            } else if(ip.getInvoiceType().equals("internal-export")){
                if (ip.getSourceId().equals(farmId)){
                    return invoicesPig;
                }
            } else if (ip.getInvoiceType().equals("internal-import")){
                if (ip.getDestinationId().equals(farmId)){
                    return invoicesPig;
                }
            } else if (ip.getInvoiceType().equals("sale")){
                if (ip.getSourceId().equals(farmId)){
                    return invoicesPig;
                }
            } else if (ip.getInvoiceType().equals("root")){
                if (ip.getSourceId().equals(farmId)){
                    return invoicesPig;
                }
            }
        }
        return Optional.empty();
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
                } else if (ip.getInvoiceType().equals("sale")){
                    if (ip.getSourceId().equals(farmId)){
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

    //Tao moi chúng tu nhap heo trong he thong
    @Transactional
    public PigsInvoicePigDTOResponse savecustom(PigsInvoicePigDTORequest pigsInvoicePigDTORequest){
        PigsInvoicePigDTOResponse response = new PigsInvoicePigDTOResponse();
        Integer userId = JwtAuthenticationFilter.userIdGlobal;
        List<Pigs> pigsList = pigsInvoicePigDTORequest.getPigsList();
        List<PigsDTO> tempPigs = new ArrayList<>();
        List<InvoicePigDetail> tempInvoicePigDetails = new ArrayList<>();
        //Lay invoicesPig ra de set lai employee
        InvoicesPig invoicesPig = pigsInvoicePigDTORequest.getInvoicesPig();
        //Lay user tu userId dang dang nhap de lay thong tin employee
        Optional<Users> user = usersService.findbyid(userId);
        invoicesPig.setEmployee(user.get().getEmployee());

        InvoicesPig tempInvoicePig = invoicePigRepository.save(invoicesPig);
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
        Integer farmId = usersService.getFarmId();
        Integer userId = JwtAuthenticationFilter.userIdGlobal;
        invoicePig.setDelFlag(false);
        Optional<Users> user = usersService.findbyid(userId);
        invoicePig.setEmployee(user.get().getEmployee());
        if (farmId.equals(0)){
            return invoicePigRepository.save(invoicePig);
        }
        if(invoicePig.getInvoiceType().equals("external-import")){
            if (invoicePig.getDestinationId().equals(farmId)){
                return invoicePigRepository.save(invoicePig);
            }
        } else if(invoicePig.getInvoiceType().equals("internal-export")){
            if (invoicePig.getSourceId().equals(farmId)){
                return invoicePigRepository.save(invoicePig);
            }
        } else if (invoicePig.getInvoiceType().equals("internal-import")){
            if (invoicePig.getDestinationId().equals(farmId)){
                return invoicePigRepository.save(invoicePig);
            }
        } else if (invoicePig.getInvoiceType().equals("sale")){
            if (invoicePig.getSourceId().equals(farmId)){
                return invoicePigRepository.save(invoicePig);
            }
        } else if (invoicePig.getInvoiceType().equals("root")){
            if (invoicePig.getSourceId().equals(farmId)){
                return invoicePigRepository.save(invoicePig);
            }
        }
        return null;
    }

    public InvoicesPig update(InvoicesPig invoicePig){
        Integer farmId = usersService.getFarmId();
        if (farmId.equals(0)){
            return invoicePigRepository.save(invoicePig);
        }
        if(invoicePig.getInvoiceType().equals("external-import")){
            if (invoicePig.getDestinationId().equals(farmId)){
                return invoicePigRepository.save(invoicePig);
            }
        } else if(invoicePig.getInvoiceType().equals("internal-export")){
            if (invoicePig.getSourceId().equals(farmId)){
                return invoicePigRepository.save(invoicePig);
            }
        } else if (invoicePig.getInvoiceType().equals("internal-import")){
            if (invoicePig.getDestinationId().equals(farmId)){
                return invoicePigRepository.save(invoicePig);
            }
        } else if (invoicePig.getInvoiceType().equals("sale")){
            if (invoicePig.getSourceId().equals(farmId)){
                return invoicePigRepository.save(invoicePig);
            }
        } else if (invoicePig.getInvoiceType().equals("root")){
            if (invoicePig.getSourceId().equals(farmId)){
                return invoicePigRepository.save(invoicePig);
            }
        }
        return null;
    }


    public Boolean delete(InvoicesPig invoicePig){
        invoicePig.setDelFlag(true);
        if(update(invoicePig) != null){
            return true;
        }
        return false;
    }
}
