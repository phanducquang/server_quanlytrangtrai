package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Employees;
import tk.giaiphapchannuoi.server.model.Warehouses;
import tk.giaiphapchannuoi.server.repository.EmployeesRepository;
import tk.giaiphapchannuoi.server.repository.WarehousesRepository;
import tk.giaiphapchannuoi.server.security.JwtAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WarehousesService {

    @Autowired
    WarehousesRepository warehousesRepository;

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    UsersService usersService;

    public List<Warehouses> findall(){
        Integer farmId = usersService.getFarmId();
        if (farmId == 0){
            return warehousesRepository.findAllByDelFlag(false);
        }
        List<Warehouses> temp = warehousesRepository.findAllByDelFlag(false);
        List<Warehouses> warehousesList = new ArrayList<>();
        for (Warehouses wh :
                temp) {
            if (wh.getManager().getFarm().getId().equals(farmId)){
                warehousesList.add(wh);
            }
        }
        return warehousesList;
    }

    public List<Warehouses> findallwarehouseofmanager(){
        Integer farmId = usersService.getFarmId();
        Integer userId = JwtAuthenticationFilter.userIdGlobal;
        Employees employees = usersService.findbyid(userId).get().getEmployee();
        if (farmId == 0){
            return warehousesRepository.findAllByDelFlag(false);
        }
        return warehousesRepository.findByManagerAndDelFlag(employees,false);
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
