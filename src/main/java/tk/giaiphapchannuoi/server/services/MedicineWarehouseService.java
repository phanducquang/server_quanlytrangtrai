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
    InvoicesProductService invoicesProductService;

    @Autowired
    WarehousesRepository warehousesRepository;

    @Autowired
    MedicinesRepository medicinesRepository;

    @Autowired
    UsersService usersService;

    public List<MedicineWarehouse> findall(){
        Integer farmId = usersService.getFarmId();
        List<MedicineWarehouse> temp = medicineWarehouseRepository.findAllByDelFlag(false);
        if (farmId.equals(0)){
            return temp;
        }
        List<MedicineWarehouse> medicineWarehouseList = new ArrayList<>();
        for (MedicineWarehouse md :
                temp) {
            if (md.getWarehouse().getManager().getFarm().getId().equals(farmId)){
                medicineWarehouseList.add(md);
            }
        }
        return medicineWarehouseList;
    }

    public Optional<MedicineWarehouse> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<MedicineWarehouse> medicineWarehouse = medicineWarehouseRepository.findByIdAndDelFlag(id,false);
        if (medicineWarehouse.isPresent()){
            if (farmId.equals(0) || medicineWarehouse.get().getWarehouse().getManager().getFarm().getId().equals(farmId)){
                return medicineWarehouse;
            }
        }
        return Optional.empty();
    }

    public List<MedicineWarehouse> findbyinvoice(Integer invoiceId){
        Integer farmId = usersService.getFarmId();
        Optional<InvoicesProduct> invoicesProduct = invoicesProductRepository.findByIdAndDelFlag(invoiceId, false);
        //Cu phap map java 8
//        return invoicesProduct.map(invoiceP -> medicineWarehouseRepository.findByInvoiceAndDelFlag(invoiceP, false)).orElse(Collections.emptyList());
        if (invoicesProduct.isPresent()){
            List<MedicineWarehouse> temp =  medicineWarehouseRepository.findByInvoiceAndDelFlag(invoicesProduct.get(),false);
            if (farmId.equals(0)){
                return temp;
            }
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

    public List<MedicineWarehouse> findbymedicine(Integer farmid, Integer medicineid){
        Optional<Medicines> medicine = medicinesRepository.findByIdAndDelFlag(medicineid, false);
        if (medicine.isPresent()){
            List<MedicineWarehouse> temp = medicineWarehouseRepository.findByMedicineAndDelFlag(medicine.get(),false);
            if (farmid == 0){
                return temp;
            }
            List<MedicineWarehouse> medicineWarehouseList = new ArrayList<>();
            for (MedicineWarehouse mw :
                    temp) {
                if (mw.getWarehouse().getManager().getFarm().getId().equals(farmid)){
                    medicineWarehouseList.add(mw);
                }
            }
            return medicineWarehouseList;
        }
        return Collections.emptyList();
    }

    public List<MedicineWarehouse> findbywarehouse(Integer warehouseId){
        Optional<Warehouses> warehouse = warehousesRepository.findByIdAndDelFlag(warehouseId, false);
        if (warehouse.isPresent()){
            Integer farmId = usersService.getFarmId();
            List<MedicineWarehouse> temp = medicineWarehouseRepository.findByWarehouseAndDelFlag(warehouse.get(),false);
            if (farmId.equals(0)){
                return temp;
            }
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

    @Transactional
    public MedicineWarehouse save(MedicineWarehouse medicineWarehouse){
        Integer farmId = usersService.getFarmId();
        Optional<Warehouses> warehouse = warehousesRepository.findByIdAndDelFlag(medicineWarehouse.getWarehouse().getId(),false);
        Integer farmIdFromWarehouse = warehouse.map(wh -> wh.getManager().getFarm().getId()).orElse(null);
        if (farmId.equals(0) || farmId.equals(farmIdFromWarehouse)){
            medicineWarehouse.setDelFlag(false);
            medicineWarehouse.setQuantity(medicineWarehouse.getTotal());
            medicineWarehouse.setRemain(medicineWarehouse.getTotal());
            medicineWarehouse.setTotalPrice(medicineWarehouse.getUnitPrice() * medicineWarehouse.getTotal());
            List<MedicineWarehouse> medicineWarehouseList = medicineWarehouseRepository.findByInvoiceAndDelFlag(medicineWarehouse.getInvoice(),false);
            if (!medicineWarehouseList.isEmpty()){
                Float total_price = medicineWarehouse.getTotalPrice();
                for (MedicineWarehouse mw :
                        medicineWarehouseList) {
                    total_price = total_price + mw.getTotalPrice();
                }
                InvoicesProduct invoicesProduct = medicineWarehouseList.get(0).getInvoice();
                invoicesProduct.setPrice(total_price);
                medicineWarehouse.setInvoice(invoicesProductService.update(invoicesProduct));
            }else{
                InvoicesProduct invoicesProduct = invoicesProductService.findbyid(medicineWarehouse.getInvoice().getId()).get();
                invoicesProduct.setPrice(medicineWarehouse.getTotalPrice());
                medicineWarehouse.setInvoice(invoicesProductService.update(invoicesProduct));
            }
            return medicineWarehouseRepository.save(medicineWarehouse);
        }
        return null;
    }

    @Transactional
    public MedicineWarehouse update(MedicineWarehouse medicineWarehouse){
        Integer farmId = usersService.getFarmId();
        Optional<Warehouses> warehouse = warehousesRepository.findByIdAndDelFlag(medicineWarehouse.getWarehouse().getId(),false);
        Integer farmIdFromWarehouse = warehouse.map(wh -> wh.getManager().getFarm().getId()).orElse(null);
        if (farmId.equals(0) || farmId.equals(farmIdFromWarehouse)){
            medicineWarehouse.setTotalPrice(medicineWarehouse.getUnitPrice() * medicineWarehouse.getTotal());
            MedicineWarehouse medicineWarehouse1 = medicineWarehouseRepository.findByIdAndDelFlag(medicineWarehouse.getId(),false).get();
            if (!medicineWarehouse1.getTotalPrice().equals(medicineWarehouse.getTotalPrice())){
                InvoicesProduct invoicesProduct = invoicesProductService.findbyid(medicineWarehouse.getInvoice().getId()).get();
                invoicesProduct.setPrice(invoicesProduct.getPrice() - medicineWarehouse1.getTotalPrice() + medicineWarehouse.getTotalPrice());
                invoicesProductService.update(invoicesProduct);
            }
            return medicineWarehouseRepository.save(medicineWarehouse);
        }
        return null;
    }

    @Transactional
    public Boolean delete(MedicineWarehouse medicineWarehouse){
        InvoicesProduct invoicesProduct = invoicesProductService.findbyid(medicineWarehouse.getInvoice().getId()).get();
        invoicesProduct.setPrice(invoicesProduct.getPrice() - medicineWarehouse.getTotalPrice());
        invoicesProductService.update(invoicesProduct);
        medicineWarehouse.setDelFlag(true);

        if(update(medicineWarehouse) != null){
            return true;
        }
        return false;
    }
}
