package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.MedicineUnits;
import tk.giaiphapchannuoi.server.repository.MedicineUnitsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicineUnitsService {

    @Autowired
    MedicineUnitsRepository medicineUnitsRepository;

    public List<MedicineUnits> findall(){
        return medicineUnitsRepository.findAllByDelFlag(false);
    }

    public Optional<MedicineUnits> findbyid(Integer id){
        return medicineUnitsRepository.findByIdAndDelFlag(id,false);
    }

    public MedicineUnits save(MedicineUnits medicineUnit){
        medicineUnit.setDelFlag(false);
        return medicineUnitsRepository.save(medicineUnit);
    }

    public MedicineUnits update(MedicineUnits medicineUnit){
        return medicineUnitsRepository.save(medicineUnit);
    }


    public Boolean delete(MedicineUnits medicineUnit){
        medicineUnit.setDelFlag(true);
        if(medicineUnitsRepository.save(medicineUnit) != null){
            return true;
        }
        return false;
    }
}
