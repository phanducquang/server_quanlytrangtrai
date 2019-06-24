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
import java.util.Collections;
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

    public List<Feeds> findbyfoodwarehouse(Integer foodWarehouseId){
        Integer farmId = usersService.getFarmId();
        FoodWarehouse foodWarehouse = foodWarehouseService.findbyid(foodWarehouseId).get();
        if (foodWarehouse.getWarehouse().getManager().getFarm().getId().equals(farmId) || farmId.equals(0)){
            return feedsRepository.findByFoodWarehouseAndDelFlag(foodWarehouse,false);

        }
        return Collections.emptyList();
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

        //Tao danh sach phan tu tu request khong trung nhau
        List<Feeds> feedsList = new ArrayList<>();
        //Gom feeds giong nhau lai 1 dong de kiem tra
        //Lay phan tu dau tien
        if (!feed.isEmpty()){
            feedsList.add(feed.get(0));
        }

        //Duyet vong lap thu nhat
        for (int i = 1; i < feed.size(); i++){
            //Duyet vong lap thu 2 de tim xem tu i tro ve truoc co trung khong, neu trung break
            for (int j = 0; j < i; j++) {
                if (feed.get(i).getFoodWarehouse().getFood().getId().equals(feed.get(j).getFoodWarehouse().getFood().getId())) {
                    break;
                }
                //Neu khong trung thi kiem tra lai lan cuoi xem vi tri j da la gia tri ke truoc i hay chua.
                //co nghia la da duyet xong vong lap thu 2 hay chua
                //Neu thoa thi them vao list
                if (j+1 == i){
                    feedsList.add(feed.get(i));
                }
            }
        }

        //Set so luong su dung cho list khong trung
        for (Feeds um :
                feedsList) {
            //Dat bien dem de bo qua khong cong quantity cua phan tu dau tien
            //(vi phan tu dau tien da la so luong trong list khong trung)
            Integer dem =0;
            //Duyet list feeds de xem neu co medicine nao trung lai thi cong tong lai
            for (Feeds ums:
                    feed) {
                if (um.getFoodWarehouse().getFood().getId().equals(ums.getFoodWarehouse().getFood().getId())){
                    if (dem > 0){
                        um.setQuantity(um.getQuantity() + ums.getQuantity());
                    }
                    dem++;
                }
            }
        }

        // Kiem tra list co dong nao quantity lon hon remain khong
        for (Feeds ff :
                feedsList) {
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
