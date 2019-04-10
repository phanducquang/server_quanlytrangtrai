package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.MedicineDisease;
import tk.giaiphapchannuoi.server.services.MedicineDiseaseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/medicinedisease")
public class MedicineDiseaseController {

    @Autowired
    MedicineDiseaseService medicineDiseaseService;

    @GetMapping(value = "/{id}")
    public Optional<MedicineDisease> findById(@PathVariable Integer id){
        return medicineDiseaseService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<MedicineDisease> findAll(){
        return medicineDiseaseService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody MedicineDisease medicineDisease){
        if(medicineDiseaseService.save(medicineDisease) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(medicineDisease);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody MedicineDisease medicineDisease){
        if(medicineDiseaseService.save(medicineDisease) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(medicineDisease);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody MedicineDisease medicineDisease){
        return medicineDiseaseService.delete(medicineDisease);
    }
}
