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
        Integer farmId = usersService.getFarmId();
        Optional<Warehouses> warehouse = warehousesRepository.findByIdAndDelFlag(id,false);
        if (warehouse.isPresent()){
            if (farmId.equals(0) || warehouse.get().getManager().getFarm().getId().equals(farmId)){
                return warehouse;
            }
        }
        return Optional.empty();
    }

    public Warehouses save(Warehouses warehouse){
        Integer farmId = usersService.getFarmId();
        Optional<Employees> employee = employeesRepository.findByIdAndDelFlag(warehouse.getManager().getId(),false);
        Integer farmIdFromWarehouse = employee.map(e -> e.getFarm().getId()).orElse(null);
        if (farmId.equals(0) || farmId.equals(farmIdFromWarehouse)){
            warehouse.setDelFlag(false);
            return warehousesRepository.save(warehouse);
        }
        return null;
    }

    public Warehouses update(Warehouses warehouse){
        Integer farmId = usersService.getFarmId();
        Optional<Employees> employee = employeesRepository.findByIdAndDelFlag(warehouse.getManager().getId(),false);
        Integer farmIdFromWarehouse = employee.map(e -> e.getFarm().getId()).orElse(null);
        if (farmId.equals(0) || farmId.equals(farmIdFromWarehouse)){
            return warehousesRepository.save(warehouse);
        }
        return null;
    }

    public Boolean delete(Warehouses warehouse){
        warehouse.setDelFlag(true);
        if(update(warehouse) != null){
            return true;
        }
        return false;
    }
}
