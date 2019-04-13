package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Warehouses;
import tk.giaiphapchannuoi.server.repository.WarehousesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WarehousesService {

    @Autowired
    WarehousesRepository warehousesRepository;

    public List<Warehouses> findall(){
        return warehousesRepository.findAllByDelFlag(false);
    }

    public Optional<Warehouses> findbyid(Integer id){
        return warehousesRepository.findByIdAndDelFlag(id,false);
    }

    public Warehouses save(Warehouses warehouse){
        warehouse.setDelFlag(false);
        return warehousesRepository.save(warehouse);
    }

    public Warehouses update(Warehouses warehouse){
        return warehousesRepository.save(warehouse);
    }

    public Boolean delete(Warehouses warehouse){
        warehouse.setDelFlag(true);
        if(warehousesRepository.save(warehouse) != null){
            return true;
        }
        return false;
    }
}
