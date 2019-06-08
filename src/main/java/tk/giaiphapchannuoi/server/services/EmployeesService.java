package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Employees;
import tk.giaiphapchannuoi.server.repository.EmployeesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeesService {

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    UsersService usersService;

    public List<Employees> findall(){
        Integer farmId = usersService.getFarmId();
        List<Employees> temp = employeesRepository.findAllByDelFlag(false);
        if (farmId == 0){
            return temp;
        }
        List<Employees> employeesList = new ArrayList<>();
        for (Employees e :
                temp) {
            if (e.getFarm().getId().equals(farmId)){
                employeesList.add(e);
            }
        }
        return employeesList;
    }

    public Optional<Employees> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<Employees> employee = employeesRepository.findByIdAndDelFlag(id,false);
        if (employee.isPresent()){
            if (employee.get().getFarm().getId().equals(farmId) || farmId == 0)
            {
                return employee;
            }
        }
        return Optional.empty();
    }

    public Employees save(Employees employee){
        Integer farmId = usersService.getFarmId();
        if (farmId.equals(0) || employee.getFarm().getId().equals(farmId)){
            employee.setDelFlag(false);
            return employeesRepository.save(employee);
        }
        return null;
    }

    public Employees update(Employees employee){
        Integer farmId = usersService.getFarmId();
        if (farmId.equals(0) || employee.getFarm().getId().equals(farmId)){
            return employeesRepository.save(employee);
        }
        return null;
    }


    public Boolean delete(Employees employee){
        Integer farmId = usersService.getFarmId();
        if (farmId.equals(0) || employee.getFarm().getId().equals(farmId)) {
            employee.setDelFlag(true);
            if (employeesRepository.save(employee) != null) {
                return true;
            }
        }
        return false;
    }
}
