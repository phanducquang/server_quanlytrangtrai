package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Employees;
import tk.giaiphapchannuoi.server.model.Feeds;
import tk.giaiphapchannuoi.server.repository.EmployeesRepository;
import tk.giaiphapchannuoi.server.repository.FeedsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FeedsService {

    @Autowired
    FeedsRepository feedsRepository;

    @Autowired
    UsersService usersService;

    @Autowired
    EmployeesRepository employeesRepository;

    public List<Feeds> findall(){
        Integer farmId = usersService.getFarmId();
        List<Feeds> temp = feedsRepository.findAllByDelFlag(false);
        if (farmId.equals(0)){
            return temp;
        }
        List<Feeds> feedsList = new ArrayList<>();
        for (Feeds f :
                temp) {
            if (f.getEmployee().getFarm().getId().equals(farmId)){
                feedsList.add(f);
            }
        }
        return feedsList;
    }

    public Optional<Feeds> findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Optional<Feeds> feed = feedsRepository.findByIdAndDelFlag(id,false);
        if (feed.isPresent()){
            if (feed.get().getEmployee().getFarm().getId().equals(farmId) || farmId.equals(0)){
                return feed;
            }
        }
        return Optional.empty();
    }

    @Transactional
    public Feeds save(Integer farmId, Feeds feed){
        Optional<Employees> employee = employeesRepository.findByIdAndDelFlag(feed.getEmployee().getId(),false);
        Integer farmIdFromEmployee = employee.map(e -> e.getFarm().getId()).orElse(null);
        if (farmIdFromEmployee.equals(farmId) || farmId.equals(0)){
            feed.setDelFlag(false);
            return feedsRepository.save(feed);
        }
        return null;
    }

    @Transactional
    public List<Feeds> savelist(List<Feeds> feed){
        List<Feeds> temp = new ArrayList<>();
        Integer farmId = usersService.getFarmId();
        for (Feeds f :
                feed) {
            temp.add(save(farmId, f));
        }
        return temp;
    }

    public Feeds update(Feeds feed){
        Integer farmId = usersService.getFarmId();
        Optional<Employees> employee = employeesRepository.findByIdAndDelFlag(feed.getEmployee().getId(),false);
        Integer farmIdFromEmployee = employee.map(e -> e.getFarm().getId()).orElse(null);
        if (farmIdFromEmployee.equals(farmId) || farmId.equals(0)){
            return feedsRepository.save(feed);
        }
        return null;
    }


    public Boolean delete(Feeds feed){
        Integer farmId = usersService.getFarmId();
        Optional<Employees> employee = employeesRepository.findByIdAndDelFlag(feed.getEmployee().getId(),false);
        Integer farmIdFromEmployee = employee.map(e -> e.getFarm().getId()).orElse(null);
        if (farmIdFromEmployee.equals(farmId) || farmId.equals(0)){
            feed.setDelFlag(true);
            if(feedsRepository.save(feed) != null){
                return true;
            }
        }
        return false;
    }
}
