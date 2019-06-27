package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.MedicineWarehouse;
import tk.giaiphapchannuoi.server.services.MedicineWarehouseService;
import tk.giaiphapchannuoi.server.services.UsersService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/medicinewarehouse")
public class MedicineWarehouseController {

    @Autowired
    MedicineWarehouseService medicineWarehouseService;

    @GetMapping(value = "/one/{id}")
    public Optional<MedicineWarehouse> findById(@PathVariable Integer id){
        return medicineWarehouseService.findbyid(id);
    }

    @GetMapping(value = "/medicine/{farmid}/{medicineid}")
    public List<MedicineWarehouse> findByMedicine(@PathVariable Integer farmid, @PathVariable Integer medicineid){
        return medicineWarehouseService.findbymedicine(farmid, medicineid);
    }

    @GetMapping(value = "/invoice/{invoiceId}")
    public List<MedicineWarehouse> findByInvoiceId(@PathVariable Integer invoiceId){
        return medicineWarehouseService.findbyinvoice(invoiceId);
    }

    @GetMapping(value = "/warehouse/{warehouseId}")
    public List<MedicineWarehouse> findByWarehouseId(@PathVariable Integer warehouseId){
        return medicineWarehouseService.findbywarehouse(warehouseId);
    }

    @GetMapping(value = "/list")
    public List<MedicineWarehouse> findAll(){
        return medicineWarehouseService.findall();
    }

    @Transactional
    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody MedicineWarehouse medicineWarehouse){
        if(medicineWarehouseService.save(medicineWarehouse) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(medicineWarehouse);
    }

    @Transactional
    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody MedicineWarehouse medicineWarehouse){
        if(medicineWarehouseService.update(medicineWarehouse) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(medicineWarehouse);
    }

    @Transactional
    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody MedicineWarehouse medicineWarehouse){
        return medicineWarehouseService.delete(medicineWarehouse);
    }
}
