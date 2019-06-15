package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.MedicineType;
import tk.giaiphapchannuoi.server.services.MedicineTypeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/medicinetype")
public class MedicineTypeController {

    @Autowired
    MedicineTypeService medicineTypeService;

    @GetMapping(value = "/one/{id}")
    public Optional<MedicineType> findById(@PathVariable Integer id){
        return medicineTypeService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<MedicineType> findAll(){
        return medicineTypeService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody MedicineType medicineType){
        MedicineType temp = medicineTypeService.save(medicineType);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody MedicineType medicineType){
        MedicineType temp = medicineTypeService.update(medicineType);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody MedicineType medicineType){
        return medicineTypeService.delete(medicineType);
    }
}
