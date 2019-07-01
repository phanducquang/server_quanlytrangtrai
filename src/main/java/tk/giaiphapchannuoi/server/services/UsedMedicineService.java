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
    MedicineUnitsService medicineUnitsService;

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

    public List<UsedMedicine> findbymedicinewarehouse(Integer medicineWarehouseId){
        Optional<MedicineWarehouse> medicineWarehouse = medicineWarehouseService.findbyid(medicineWarehouseId);
        if (medicineWarehouse.isPresent()){
            Integer farmId = usersService.getFarmId();
            if (farmId.equals(0) || medicineWarehouse.get().getWarehouse().getManager().getId().equals(farmId)){
                return usedMedicineRepository.findByMedicineWarehouseAndDelFlag(medicineWarehouse.get(),false);
            }
        }
        return Collections.emptyList();
    }

    @Transactional
    public List<UsedMedicine> save(List<UsedMedicine> usedMedicine){
        List<UsedMedicine> temp = new ArrayList<>();
        //Lay danh sach medicineDisease
        List<MedicineDisease> medicineDiseaseList = medicineDiseaseService.findbyDisease(usedMedicine.get(0).getDiseases());
        //Lay danh sach medicineWarehouse
        List<MedicineWarehouse> medicineWarehouseList = medicineWarehouseService.findall();
        //Tao danh sach phan tu tu request khong trung nhau
        List<UsedMedicine> usedMedicineList = new ArrayList<>();
        //Gom usedMedicine giong nhau lai 1 dong de kiem tra
        //Lay phan tu dau tien
        if (!usedMedicine.isEmpty()){
            UsedMedicine usedMedicine_temp = new UsedMedicine(usedMedicine.get(0).getForPigId(),usedMedicine.get(0).getDiseases(),usedMedicine.get(0).getMedicineWarehouse(),usedMedicine.get(0).getUnit(),usedMedicine.get(0).getQuantity(),usedMedicine.get(0).getDate(),usedMedicine.get(0).getEmployee(),usedMedicine.get(0).getDescription(),usedMedicine.get(0).getDelFlag());
            usedMedicine_temp.setId(usedMedicine.get(0).getId());
            usedMedicineList.add(usedMedicine_temp);
        }
        //Duyet vong lap thu nhat
        for (int i = 1; i < usedMedicine.size(); i++){
            //Duyet vong lap thu 2 de tim xem tu i tro ve truoc co trung khong, neu trung break
            for (int j = 0; j < i; j++) {
                if (usedMedicine.get(i).getMedicineWarehouse().getMedicine().getId().equals(usedMedicine.get(j).getMedicineWarehouse().getMedicine().getId())) {
                    break;
                }
                //Neu khong trung thi kiem tra lai lan cuoi xem vi tri j da la gia tri ke truoc i hay chua.
                //co nghia la da duyet xong vong lap thu 2 hay chua
                //Neu thoa thi them vao list
                if (j+1 == i){
                    UsedMedicine usedMedicine_temp = new UsedMedicine(usedMedicine.get(i).getForPigId(),usedMedicine.get(i).getDiseases(),usedMedicine.get(i).getMedicineWarehouse(),usedMedicine.get(i).getUnit(),usedMedicine.get(i).getQuantity(),usedMedicine.get(i).getDate(),usedMedicine.get(i).getEmployee(),usedMedicine.get(i).getDescription(),usedMedicine.get(i).getDelFlag());
                    usedMedicine_temp.setId(usedMedicine.get(i).getId());
                    usedMedicineList.add(usedMedicine_temp);
                }
            }
        }
        //Set so luong su dung cho list khong trung
        for (UsedMedicine um :
                usedMedicineList) {
            //Dat bien dem de bo qua khong cong quantity cua phan tu dau tien
            //(vi phan tu dau tien da la so luong trong list khong trung)
            Integer dem =0;
            //Duyet list usedMedicine de xem neu co medicine nao trung lai thi cong tong lai
            for (UsedMedicine ums:
                 usedMedicine) {
                if (um.getMedicineWarehouse().getMedicine().getId().equals(ums.getMedicineWarehouse().getMedicine().getId())){
                    if (dem > 0){
                        um.setQuantity(um.getQuantity() + ums.getQuantity());
                    }
                    dem++;
                }
            }
        }
        //Kiem tra luong remain nho hon luong dung thi bao loi
        for (UsedMedicine umf :
                usedMedicineList) {
            for (MedicineWarehouse mw :
                    medicineWarehouseList) {
                //tim tung dong cua usedMedicine trong medicineWarehouseList
                if (mw.getId().equals(umf.getMedicineWarehouse().getId())){
                    //Neu co 1 dong so luong con lai nho hon so luong dung tra ve null de bao loi khong luu data vào db
                    Float remain = mw.getRemain() * mw.getUnit().getQuantity();
                    Float quantity = umf.getQuantity() * medicineUnitsService.findbyid(umf.getUnit()).get().getQuantity();
                    if (remain < quantity){
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
                    //tính quantity voi don vi moi (unit) cua medicinde nhap vao usedMedicine
                    Float quantity = um.getQuantity() * medicineUnitsService.findbyid(um.getUnit()).get().getQuantity();
                    //Tinh luọng da su dung sau khi nhap quantity vao usedMedicine
                    //chuyen sang don vi co ban (base_unit) roi tinh . khi tinh xg chuyen ve don vi goc
                    Float used = (mw.getUsed()*mw.getUnit().getQuantity() + quantity)/mw.getUnit().getQuantity();
                    //Tính luọng con lai sau khi nhap quantity vao usedMedicine
                    Float remain = (mw.getQuantity() - used);
                    mw.setUsed(used);
                    mw.setRemain(remain);
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
