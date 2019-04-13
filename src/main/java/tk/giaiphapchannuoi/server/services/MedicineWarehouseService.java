package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.MedicineWarehouse;
import tk.giaiphapchannuoi.server.repository.MedicineWarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicineWarehouseService {

    @Autowired
    MedicineWarehouseRepository medicineWarehouseRepository;

    public List<MedicineWarehouse> findall(){
        return medicineWarehouseRepository.findAllByDelFlag(false);
    }

    public Optional<MedicineWarehouse> findbyid(Integer id){
        return medicineWarehouseRepository.findByIdAndDelFlag(id,false);
    }

    public MedicineWarehouse save(MedicineWarehouse medicineWarehouse){
        medicineWarehouse.setDelFlag(false);
        return medicineWarehouseRepository.save(medicineWarehouse);
    }

    public MedicineWarehouse update(MedicineWarehouse medicineWarehouse){
        return medicineWarehouseRepository.save(medicineWarehouse);
    }

    public Boolean delete(MedicineWarehouse medicineWarehouse){
        medicineWarehouse.setDelFlag(true);
        if(medicineWarehouseRepository.save(medicineWarehouse) != null){
            return true;
        }
        return false;
    }
}
