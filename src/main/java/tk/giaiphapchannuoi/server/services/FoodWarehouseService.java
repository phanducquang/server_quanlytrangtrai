package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.FoodWarehouse;
import tk.giaiphapchannuoi.server.model.InvoicesProduct;
import tk.giaiphapchannuoi.server.model.Warehouses;
import tk.giaiphapchannuoi.server.repository.FoodWarehouseRepository;
import tk.giaiphapchannuoi.server.repository.InvoicesProductRepository;
import tk.giaiphapchannuoi.server.repository.WarehousesRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FoodWarehouseService {

    @Autowired
    FoodWarehouseRepository foodWarehouseRepository;

    @Autowired
    InvoicesProductRepository invoicesProductRepository;

    @Autowired
    WarehousesRepository warehousesRepository;

    @Autowired
    UsersService usersService;

    public List<FoodWarehouse> findall(){
        Integer farmId = usersService.getFarmId();
        List<FoodWarehouse> temp = foodWarehouseRepository.findAllByDelFlag(false);
        if (farmId.equals(0)){
            return temp;
        }
        List<FoodWarehouse> foodWarehouseList = new ArrayList<>();
        for (FoodWarehouse fw :
                temp) {
            if (fw.getWarehouse().getManager().getFarm().getId().equals(farmId)){
                foodWarehouseList.add(fw);
            }
        }
        return foodWarehouseList;
    }

    public Optional<FoodWarehouse> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<FoodWarehouse> foodWarehouse = foodWarehouseRepository.findByIdAndDelFlag(id,false);
        if (foodWarehouse.isPresent()){
            if (foodWarehouse.get().getWarehouse().getManager().getFarm().getId().equals(farmId) || farmId.equals(0)) {
                return foodWarehouse;
            }
        }
        return Optional.empty();
    }

    public List<FoodWarehouse> findbyinvoices(Integer invoiceId){
        Integer farmId = usersService.getFarmId();
        Optional<InvoicesProduct> invoicesProduct = invoicesProductRepository.findByIdAndDelFlag(invoiceId, false);
        if (invoicesProduct.isPresent()){
            List<FoodWarehouse> temp = foodWarehouseRepository.findByInvoiceAndDelFlag(invoicesProduct.get(),false);
            if (farmId.equals(0)){
                return temp;
            }
            List<FoodWarehouse> foodWarehouseList = new ArrayList<>();
            for (FoodWarehouse fw :
                    temp) {
                if (fw.getWarehouse().getManager().getFarm().getId().equals(farmId)){
                    foodWarehouseList.add(fw);
                }
            }
            return foodWarehouseList;
        }
        return Collections.emptyList();
    }

    public List<FoodWarehouse> findbywarehouse(Integer warehouseId){
        Integer farmId = usersService.getFarmId();

        Optional<Warehouses> warehouse = warehousesRepository.findByIdAndDelFlag(warehouseId, false);
        if (warehouse.isPresent()){
            List<FoodWarehouse> temp = foodWarehouseRepository.findByWarehouseAndDelFlag(warehouse.get(),false);
            if (farmId.equals(0)){
                return temp;
            }
            List<FoodWarehouse> foodWarehouseList = new ArrayList<>();
            for (FoodWarehouse fw :
                    temp) {
                if (fw.getWarehouse().getManager().getFarm().getId().equals(farmId)){
                    foodWarehouseList.add(fw);
                }
            }
            return foodWarehouseList;
        }
        return Collections.emptyList();
    }

    public FoodWarehouse save(FoodWarehouse foodWarehouse){
        Integer farmId = usersService.getFarmId();
        Optional<Warehouses> warehouses = warehousesRepository.findByIdAndDelFlag(foodWarehouse.getWarehouse().getId(),false);
        Integer farmIDFromWarehouse = warehouses.map(w -> w.getManager().getFarm().getId()).orElse(null);
        if (farmId.equals(farmIDFromWarehouse) || farmId.equals(0)){
            foodWarehouse.setDelFlag(false);
            return foodWarehouseRepository.save(foodWarehouse);
        }
        return null;
    }

    public FoodWarehouse update(FoodWarehouse foodWarehouse){
        Integer farmId = usersService.getFarmId();
        Optional<Warehouses> warehouses = warehousesRepository.findByIdAndDelFlag(foodWarehouse.getWarehouse().getId(),false);
        Integer farmIDFromWarehouse = warehouses.map(w -> w.getManager().getFarm().getId()).orElse(null);
        if (farmId.equals(farmIDFromWarehouse) || farmId.equals(0)){
            return foodWarehouseRepository.save(foodWarehouse);
        }
        return null;
    }


    public Boolean delete(FoodWarehouse foodWarehouse){
        Integer farmId = usersService.getFarmId();
        Optional<Warehouses> warehouses = warehousesRepository.findByIdAndDelFlag(foodWarehouse.getWarehouse().getId(),false);
        Integer farmIDFromWarehouse = warehouses.map(w -> w.getManager().getFarm().getId()).orElse(null);
        if (farmId.equals(farmIDFromWarehouse) || farmId.equals(0)){
            foodWarehouse.setDelFlag(true);
            if(foodWarehouseRepository.save(foodWarehouse) != null){
                return true;
            }
        }
        return false;
    }
}
