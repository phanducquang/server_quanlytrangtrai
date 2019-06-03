package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.UsedMedicine;
import tk.giaiphapchannuoi.server.repository.UsedMedicineRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsedMedicineService {

    @Autowired
    UsedMedicineRepository usedMedicineRepository;

    public List<UsedMedicine> findall(){
        return usedMedicineRepository.findAllByDelFlag(false);
    }

    public Optional<UsedMedicine> findbyid(Integer id){
        return usedMedicineRepository.findByIdAndDelFlag(id,false);
    }

    public UsedMedicine save(UsedMedicine usedMedicine){
        usedMedicine.setDelFlag(false);
        return usedMedicineRepository.save(usedMedicine);
    }

    public UsedMedicine update(UsedMedicine usedMedicine){
        return usedMedicineRepository.save(usedMedicine);
    }

    public Boolean delete(UsedMedicine usedMedicine){
        usedMedicine.setDelFlag(true);
        if(usedMedicineRepository.save(usedMedicine) != null){
            return true;
        }
        return false;
    }
}
