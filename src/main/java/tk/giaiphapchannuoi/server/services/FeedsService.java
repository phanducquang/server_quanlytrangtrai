package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Employees;
import tk.giaiphapchannuoi.server.model.Feeds;
import tk.giaiphapchannuoi.server.model.FoodWarehouse;
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

    @Autowired
    FoodWarehouseService foodWarehouseService;

    @Autowired
    FoodUnitsService foodUnitsService;

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
        List<FoodWarehouse> foodWarehouseList = foodWarehouseService.findall();
        // Kiem tra list co dong nao quantity lon hon remain khong
        for (Feeds ff :
                feed) {
            for (FoodWarehouse fw :
                    foodWarehouseList) {
                if (ff.getFoodWarehouse().getId().equals(fw.getId())){
                    Float remain = fw.getRemain() * fw.getUnit().getQuantity();
                    Float quantity = ff.getQuantity() * foodUnitsService.findbyid(ff.getUnit()).get().getQuantity();
                    if (quantity > remain){
                        return null;
                    }
                }
            }
        }
        for (Feeds f :
                feed) {
            //Cap nhat so luong ton kho
            for (FoodWarehouse fw :
                    foodWarehouseList) {
                if (f.getFoodWarehouse().getId().equals(fw.getId())){
                    if (f.getQuantity() > fw.getRemain()){
                        //tính quantity voi don vi moi (unit) cua food nhap vao feeds
                        Float quantity = f.getQuantity() * foodUnitsService.findbyid(f.getUnit()).get().getQuantity();
                        //Tinh luọng da su dung sau khi nhap quantity vao feeds
                        //chuyen sang don vi co ban (base_unit) roi tinh . khi tinh xg chuyen ve don vi goc
                        Float used = (fw.getUsed()*fw.getUnit().getQuantity() + quantity)/fw.getUnit().getQuantity();
                        //Tính luọng con lai sau khi nhap quantity vao feeds
                        Float remain = (fw.getQuantity()*fw.getUnit().getQuantity() - used)/fw.getUnit().getQuantity();
                        fw.setUsed(used);
                        fw.setRemain(remain);
                        foodWarehouseService.update(fw);
                    }
                }
            }
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
