package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Employees;
import tk.giaiphapchannuoi.server.repository.EmployeesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeesService {

    @Autowired
    EmployeesRepository employeesRepository;

    public List<Employees> findall(){
        return employeesRepository.findAllByDelFlag(false);
    }

    public Optional<Employees> findbyid(Integer id){
        return employeesRepository.findByIdAndDelFlag(id,false);
    }

    public Employees save(Employees employee){
        return employeesRepository.save(employee);
    }

    public Boolean delete(Employees employee){
        employee.setDelFlag(true);
        if(employeesRepository.save(employee) != null){
            return true;
        }
        return false;
    }
}
