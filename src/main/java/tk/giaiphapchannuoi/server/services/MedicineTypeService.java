package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.MedicineType;
import tk.giaiphapchannuoi.server.repository.MedicineTypeRepository;
import tk.giaiphapchannuoi.server.repository.MedicinesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicineTypeService {

    @Autowired
    MedicineTypeRepository medicineTypeRepository;

    public List<MedicineType> findall(){
        return medicineTypeRepository.findAllByDelFlag(false);
    }

    public Optional<MedicineType> findbyid(Integer id){
        return medicineTypeRepository.findByIdAndDelFlag(id,false);
    }

    public MedicineType save(MedicineType medicineType){
        return medicineTypeRepository.save(medicineType);
    }

    public Boolean delete(MedicineType medicineType){
        medicineType.setDelFlag(true);
        if(medicineTypeRepository.save(medicineType) != null){
            return true;
        }
        return false;
    }
}
