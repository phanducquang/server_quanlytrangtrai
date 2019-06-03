package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping(value = "/{id}")
    public Optional<UsedMedicine> findById(@PathVariable Integer id){
        return usedMedicineService.findbyid(id);
    }

    @GetMapping(value = "/list")
    public List<UsedMedicine> findAll(){
        return usedMedicineService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody UsedMedicine usedMedicine){
        UsedMedicine temp = usedMedicineService.save(usedMedicine);
        if(temp == null){
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
