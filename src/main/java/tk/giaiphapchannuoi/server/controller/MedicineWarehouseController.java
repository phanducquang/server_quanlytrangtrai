package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tk.giaiphapchannuoi.server.model.MedicineWarehouse;
import tk.giaiphapchannuoi.server.services.MedicineWarehouseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/medicinewarehouse")
public class MedicineWarehouseController {

    @Autowired
    MedicineWarehouseService medicineWarehouseService;

    @GetMapping(value = "/{id}")
    public Optional<MedicineWarehouse> findById(@PathVariable Integer id){
        return medicineWarehouseService.findbyid(id);
    }

    @GetMapping(value = "/invoice/{invoiceId}")
    public List<MedicineWarehouse> findByInvoiceId(@PathVariable Integer invoiceId){
        return medicineWarehouseService.findbyinvoice(invoiceId);
    }

    @GetMapping(value = "/list")
    public List<MedicineWarehouse> findAll(){
        return medicineWarehouseService.findall();
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object> insert(@RequestBody MedicineWarehouse medicineWarehouse){
        if(medicineWarehouseService.save(medicineWarehouse) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(medicineWarehouse);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Object> update(@RequestBody MedicineWarehouse medicineWarehouse){
        if(medicineWarehouseService.update(medicineWarehouse) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(medicineWarehouse);
    }

    @DeleteMapping(value = "/")
    public Boolean delete(@RequestBody MedicineWarehouse medicineWarehouse){
        return medicineWarehouseService.delete(medicineWarehouse);
    }
}
