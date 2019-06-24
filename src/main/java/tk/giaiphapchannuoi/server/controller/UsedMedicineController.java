package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.UsedMedicine;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.services.UsedMedicineService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/usedmedicine")
public class UsedMedicineController {

    @Autowired
    UsedMedicineService usedMedicineService;

    @GetMapping(value = "/one/{id}")
    public Optional<UsedMedicine> findById(@PathVariable Integer id){
        return usedMedicineService.findbyid(id);
    }

    @GetMapping(value = "/medicinewarehouse/{medicineWarehouseId}")
    public List<UsedMedicine> findByMedicineWarehouse(@PathVariable Integer medicineWarehouseId){
        return usedMedicineService.findbymedicinewarehouse(medicineWarehouseId);
    }

    @GetMapping(value = "/list")
    public List<UsedMedicine> findAll(){
        return usedMedicineService.findall();
    }

    @Transactional
    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody List<UsedMedicine> usedMedicine){
        List<UsedMedicine> temp = usedMedicineService.save(usedMedicine);
        if (temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("1432: so luong con lai khong du");
        } else if(temp.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
            return ResponseEntity.ok(temp);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody UsedMedicine usedMedicine){
        UsedMedicine temp = usedMedicineService.update(usedMedicine);
        if(temp == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody UsedMedicine usedMedicine){
        return usedMedicineService.delete(usedMedicine);
    }
}
