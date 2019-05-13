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

    public List<FoodWarehouse> findall(){
        return foodWarehouseRepository.findAllByDelFlag(false);
    }

    public Optional<FoodWarehouse> findbyid(Integer id){
        return foodWarehouseRepository.findByIdAndDelFlag(id,false);
    }

    public List<FoodWarehouse> findbyinvoices(Integer invoiceId){
        Optional<InvoicesProduct> invoicesProduct = invoicesProductRepository.findByIdAndDelFlag(invoiceId, false);
        return foodWarehouseRepository.findByInvoiceAndDelFlag(invoicesProduct.get(),false);
    }

    public List<FoodWarehouse> findbywarehouse(Integer warehouseId){
        Optional<Warehouses> warehouse = warehousesRepository.findByIdAndDelFlag(warehouseId, false);
        return foodWarehouseRepository.findByWarehouseAndDelFlag(warehouse.get(),false);
    }

    public FoodWarehouse save(FoodWarehouse foodWarehouse){
        foodWarehouse.setDelFlag(false);
        return foodWarehouseRepository.save(foodWarehouse);
    }

    public FoodWarehouse update(FoodWarehouse foodWarehouse){
        return foodWarehouseRepository.save(foodWarehouse);
    }


    public Boolean delete(FoodWarehouse foodWarehouse){
        foodWarehouse.setDelFlag(true);
        if(foodWarehouseRepository.save(foodWarehouse) != null){
            return true;
        }
        return false;
    }
}
