package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.DTO.Pigs1DTO;
import tk.giaiphapchannuoi.server.model.MedicineDisease;
import tk.giaiphapchannuoi.server.model.MedicineWarehouse;
import tk.giaiphapchannuoi.server.model.UsedMedicine;
import tk.giaiphapchannuoi.server.repository.Pigs1DTORepository;
import tk.giaiphapchannuoi.server.repository.UsedMedicineRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsedMedicineService {

    @Autowired
    UsedMedicineRepository usedMedicineRepository;

    @Autowired
    Pigs1DTORepository pigs1DTORepository;

    @Autowired
    MedicineDiseaseService medicineDiseaseService;

    @Autowired
    MedicineWarehouseService medicineWarehouseService;

    @Autowired
    UsersService usersService;

    public List<UsedMedicine> findall(){
        Integer farmId = usersService.getFarmId();
        List<UsedMedicine> temp = usedMedicineRepository.findAllByDelFlag(false);
        if (farmId.equals(0)){
            return temp;
        }
        List<UsedMedicine> usedMedicineList = new ArrayList<>();
        for (UsedMedicine um :
                temp) {
            if (um.getForPigId().getHouse().getSection().getFarm().getId().equals(farmId)){
                usedMedicineList.add(um);
            }
        }
        return usedMedicineList;
    }

    public Optional<UsedMedicine> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<UsedMedicine> usedMedicine = usedMedicineRepository.findByIdAndDelFlag(id,false);
        if (usedMedicine.isPresent()){
            if (farmId.equals(0) || usedMedicine.get().getForPigId().getHouse().getSection().getFarm().getId().equals(farmId)){
                return usedMedicine;
            }
        }
        return Optional.empty();
    }

    @Transactional
    public List<UsedMedicine> save(List<UsedMedicine> usedMedicine){
        List<UsedMedicine> temp = new ArrayList<>();
        //Lay danh sach medicineDisease
        List<MedicineDisease> medicineDiseaseList = medicineDiseaseService.findbyDisease(usedMedicine.get(0).getDiseases());
        //Lay danh sach medicineWarehouse
        List<MedicineWarehouse> medicineWarehouseList = medicineWarehouseService.findall();
        //Kiem tra luong remain nho hon luong dung thi bao loi
        for (UsedMedicine umf :
                usedMedicine) {
            for (MedicineWarehouse mw :
                    medicineWarehouseList) {
                //tim tung dong cua usedMedicine trong medicineWarehouseList
                if (mw.getId().equals(umf.getMedicineWarehouse().getId())){
                    //Neu co 1 dong so luong con lai nho hon so luong dung tra ve null de bao loi khong luu data vào db
                    if (mw.getRemain() < umf.getQuantity()){
                        return null;
                    }
                }
            }
        }
        for (UsedMedicine um :
                usedMedicine) {
            um.setDelFlag(false);
            for (MedicineWarehouse mw :
            medicineWarehouseList){
                //tim tung dong cua usedMedicine trong medicineWarehouseList
                if (mw.getId().equals(um.getMedicineWarehouse().getId())) {
                    mw.setUsed(mw.getUsed() + um.getQuantity());
                    mw.setRemain(mw.getQuantity() - mw.getUsed());
                    medicineWarehouseService.update(mw);
                }
            }
            //Chạy vong lap kiem tra tung disease và medicine cua usedMedicine da ton tai trong medicineDiseaseList hay khong.
            //Neu trung tang bien dem len 1. neu dem == 0 them vao data cua medicineDisease
            Integer dem_trung = 0;//dem bao nhieu dong trung
            for (MedicineDisease md :
                    medicineDiseaseList) {
                if (md.getMedicine().getId().equals(um.getMedicineWarehouse().getMedicine().getId())) {
                    dem_trung++;
                }
            }
            if (dem_trung.equals(0)){
                medicineDiseaseService.save(new MedicineDisease(um.getMedicineWarehouse().getMedicine(),um.getDiseases(),false));
            }
            temp.add(usedMedicineRepository.save(um));
        }
        return temp;
    }

    public UsedMedicine update(UsedMedicine usedMedicine){
        Integer farmId = usersService.getFarmId();
        Optional<Pigs1DTO> pig = pigs1DTORepository.findByIdAndDelFlag(usedMedicine.getForPigId().getId(),false);
        Integer farmIdFromUsedMedicine = pig.map(p -> p.getHouse().getSection().getFarm().getId()).orElse(-1);
        if (farmId.equals(0) || farmId.equals(farmIdFromUsedMedicine)){
            return usedMedicineRepository.save(usedMedicine);
        }
        return null;
    }

    public Boolean delete(UsedMedicine usedMedicine){
        usedMedicine.setDelFlag(true);
        if(update(usedMedicine) != null){
            return true;
        }
        return false;
    }
}
