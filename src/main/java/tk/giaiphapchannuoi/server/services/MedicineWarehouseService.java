package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.InvoicesProduct;
import tk.giaiphapchannuoi.server.model.MedicineWarehouse;
import tk.giaiphapchannuoi.server.model.Medicines;
import tk.giaiphapchannuoi.server.model.Warehouses;
import tk.giaiphapchannuoi.server.repository.InvoicesProductRepository;
import tk.giaiphapchannuoi.server.repository.MedicineWarehouseRepository;
import tk.giaiphapchannuoi.server.repository.MedicinesRepository;
import tk.giaiphapchannuoi.server.repository.WarehousesRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicineWarehouseService {

    @Autowired
    MedicineWarehouseRepository medicineWarehouseRepository;

    @Autowired
    InvoicesProductRepository invoicesProductRepository;

    @Autowired
    WarehousesRepository warehousesRepository;

    @Autowired
    MedicinesRepository medicinesRepository;

    @Autowired
    UsersService usersService;

    public List<MedicineWarehouse> findall(){
        return medicineWarehouseRepository.findAllByDelFlag(false);
    }

    public Optional<MedicineWarehouse> findbyid(Integer id){
        return medicineWarehouseRepository.findByIdAndDelFlag(id,false);
    }

    public List<MedicineWarehouse> findbyinvoice(Integer invoiceId){
        Optional<InvoicesProduct> invoicesProduct = invoicesProductRepository.findByIdAndDelFlag(invoiceId, false);
        //Cu phap map java 8
        return invoicesProduct.map(invoiceP -> medicineWarehouseRepository.findByInvoiceAndDelFlag(invoiceP, false)).orElse(Collections.emptyList());
//        if (invoicesProduct.isPresent()){
//            return medicineWarehouseRepository.findByInvoiceAndDelFlag(invoicesProduct.get(),false);
//        }
//        return Collections.emptyList();
    }

    public List<MedicineWarehouse> findbymedicine(Integer medicineid){
        Optional<Medicines> medicine = medicinesRepository.findByIdAndDelFlag(medicineid, false);
        if (medicine.isPresent()){
            Integer farmId = usersService.getFarmId();
            List<MedicineWarehouse> temp = medicineWarehouseRepository.findByMedicineAndDelFlag(medicine.get(),false);
            List<MedicineWarehouse> medicineWarehouseList = new ArrayList<>();
            for (MedicineWarehouse mw :
                    temp) {
                if (mw.getWarehouse().getManager().getFarm().getId().equals(farmId)){
                    medicineWarehouseList.add(mw);
                }
            }
            return medicineWarehouseList;
        }
        return Collections.emptyList();
    }

    public List<MedicineWarehouse> findbywarehouse(Integer warehouseId){
        Optional<Warehouses> warehouse = warehousesRepository.findByIdAndDelFlag(warehouseId, false);
        return medicineWarehouseRepository.findByWarehouseAndDelFlag(warehouse.get(),false);
    }

    public MedicineWarehouse save(MedicineWarehouse medicineWarehouse){
        medicineWarehouse.setDelFlag(false);
        return medicineWarehouseRepository.save(medicineWarehouse);
    }

    public MedicineWarehouse update(MedicineWarehouse medicineWarehouse){
        return medicineWarehouseRepository.save(medicineWarehouse);
    }

    public Boolean delete(MedicineWarehouse medicineWarehouse){
        medicineWarehouse.setDelFlag(true);
        if(medicineWarehouseRepository.save(medicineWarehouse) != null){
            return true;
        }
        return false;
    }
}
