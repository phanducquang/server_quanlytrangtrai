package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.MedicineUnits;
import tk.giaiphapchannuoi.server.services.MedicineUnitsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/medicineunits")
public class MedicineUnitsController {

    @Autowired
    MedicineUnitsService medicineUnitsService;

    @GetMapping(value = "/{id}")
    public Optional<MedicineUnits> findById(@PathVariable Integer id){
        return medicineUnitsService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<MedicineUnits> findAll(){
        return medicineUnitsService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody MedicineUnits medicineUnit){
        MedicineUnits temp = medicineUnitsService.save(medicineUnit);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody MedicineUnits medicineUnit){
        MedicineUnits temp = medicineUnitsService.update(medicineUnit);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody MedicineUnits medicineUnit){
        return medicineUnitsService.delete(medicineUnit);
    }
}
