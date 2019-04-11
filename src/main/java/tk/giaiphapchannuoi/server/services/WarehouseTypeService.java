package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.WarehouseType;
import tk.giaiphapchannuoi.server.repository.WarehouseTypeRepositry;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WarehouseTypeService {

    @Autowired
    WarehouseTypeRepositry warehouseTypeRepositry;

    public List<WarehouseType> findall(){
        return warehouseTypeRepositry.findAllByDelFlag(false);
    }

    public Optional<WarehouseType> findbyid(Integer id){
        return warehouseTypeRepositry.findByIdAndDelFlag(id,false);
    }

    public WarehouseType save(WarehouseType warehouseType){
        return warehouseTypeRepositry.save(warehouseType);
    }

    public Boolean delete(WarehouseType warehouseType){
        warehouseType.setDelFlag(true);
        if(warehouseTypeRepositry.save(warehouseType) != null){
            return true;
        }
        return false;
    }
}
