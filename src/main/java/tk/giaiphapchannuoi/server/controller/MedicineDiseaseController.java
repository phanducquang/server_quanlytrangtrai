package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.MedicineDisease;
import tk.giaiphapchannuoi.server.model.Medicines;
import tk.giaiphapchannuoi.server.services.MedicineDiseaseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/medicinedisease")
public class MedicineDiseaseController {

    @Autowired
    MedicineDiseaseService medicineDiseaseService;

    @GetMapping(value = "/{id}")
    public Optional<MedicineDisease> findById(@PathVariable Integer id){
        return medicineDiseaseService.findbyid(id);
    }

    @GetMapping(value = "/disease/{diseaseId}")
    public List<Medicines> findMedicineByDisease(@PathVariable Integer diseaseId){
        return medicineDiseaseService.findMedicineByDisease(diseaseId);
    }

    @GetMapping(value = "/list")
    public List<MedicineDisease> findAll(){
        return medicineDiseaseService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody MedicineDisease medicineDisease){
        MedicineDisease temp = medicineDiseaseService.save(medicineDisease);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody MedicineDisease medicineDisease){
        MedicineDisease temp = medicineDiseaseService.update(medicineDisease);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody MedicineDisease medicineDisease){
        return medicineDiseaseService.delete(medicineDisease);
    }
}
