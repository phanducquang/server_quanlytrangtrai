package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Medicines;
import tk.giaiphapchannuoi.server.repository.MedicinesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicinesService {

    @Autowired
    MedicinesRepository medicinesRepository;

    public List<Medicines> findall(){
        return medicinesRepository.findAllByDelFlag(false);
    }

    public Optional<Medicines> findbyid(Integer id){
        return medicinesRepository.findByIdAndDelFlag(id,false);
    }

    public Medicines save(Medicines medicine){
        return medicinesRepository.save(medicine);
    }

    public Boolean delete(Medicines medicine){
        medicine.setDelFlag(true);
        if(medicinesRepository.save(medicine) != null){
            return true;
        }
        return false;
    }
}
