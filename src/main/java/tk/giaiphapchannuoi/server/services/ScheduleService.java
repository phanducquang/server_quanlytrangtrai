package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Employees;
import tk.giaiphapchannuoi.server.model.Schedule;
import tk.giaiphapchannuoi.server.repository.EmployeesRepository;
import tk.giaiphapchannuoi.server.repository.ScheduleRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    EmployeesService employeesService;

    @Autowired
    UsersService usersService;

    public List<Schedule> findall(){
        Integer farmId = usersService.getFarmId();
        List<Schedule> temp = scheduleRepository.findAllByDelFlag(false);
        if (farmId.equals(0)){
            return temp;
        }
        List<Schedule> scheduleList = new ArrayList<>();
        for (Schedule s :
                temp) {
            if (s.getFarmId().equals(farmId)){
                scheduleList.add(s);
            }
        }
        return scheduleList;
    }

    public Optional<Schedule> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<Schedule> schedule = scheduleRepository.findByIdAndDelFlag(id,false);
        if (schedule.isPresent()){
            if (farmId.equals(0) || schedule.get().getFarmId().equals(farmId)){
                return schedule;
            }
        }
        return Optional.empty();
    }

    public List<Schedule> findbyemployee(Integer employeeId){
        Optional<Employees> employee = employeesService.findbyid(employeeId);
        if (employee.isPresent()){
            return scheduleRepository.findByEmployeeAndDelFlag(employee.get(),false);
        }
        return Collections.emptyList();
    }

    public Schedule save(Schedule schedule){
        schedule.setDelFlag(false);
        return scheduleRepository.save(schedule);
    }

    public Schedule update(Schedule schedule){
        Integer farmId = usersService.getFarmId();
        if (farmId.equals(0) || farmId.equals(schedule.getFarmId())){
            return scheduleRepository.save(schedule);
        }
        return null;
    }

    public Boolean delete(Schedule schedule){
        schedule.setDelFlag(true);
        if(update(schedule) != null){
            return true;
        }
        return false;
    }
}
