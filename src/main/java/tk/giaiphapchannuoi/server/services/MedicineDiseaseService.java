package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Diseases;
import tk.giaiphapchannuoi.server.model.MedicineDisease;
import tk.giaiphapchannuoi.server.model.Medicines;
import tk.giaiphapchannuoi.server.repository.DiseasesRepository;
import tk.giaiphapchannuoi.server.repository.MedicineDiseaseRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicineDiseaseService {

    @Autowired
    MedicineDiseaseRepository medicineDiseaseRepository;

    @Autowired
    DiseasesRepository diseasesRepository;

    public List<MedicineDisease> findall(){
        return medicineDiseaseRepository.findAllByDelFlag(false);
    }

    public Optional<MedicineDisease> findbyid(Integer id){
        return medicineDiseaseRepository.findByIdAndDelFlag(id,false);
    }

    public List<Medicines> findMedicineByDisease(Integer diseaseId){
        Optional<Diseases> diseases = diseasesRepository.findByIdAndDelFlag(diseaseId,false);
        if (diseases.isPresent()){
            List<MedicineDisease> temp = medicineDiseaseRepository.findByDiseaseAndDelFlag(diseases.get(),false);
            List<Medicines> medicinesList = new ArrayList<>();;
            for (MedicineDisease md :
                    temp) {
                medicinesList.add(md.getMedicine());
            }
            return medicinesList;
        }
        return Collections.emptyList();
    }

    public MedicineDisease save(MedicineDisease medicineDisease){
        medicineDisease.setDelFlag(false);
        return medicineDiseaseRepository.save(medicineDisease);
    }

    public MedicineDisease update(MedicineDisease medicineDisease){
        return medicineDiseaseRepository.save(medicineDisease);
    }

    public Boolean delete(MedicineDisease medicineDisease){
        medicineDisease.setDelFlag(true);
        if(medicineDiseaseRepository.save(medicineDisease) != null){
            return true;
        }
        return false;
    }
}
