package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Births;
import tk.giaiphapchannuoi.server.model.Matings;
import tk.giaiphapchannuoi.server.repository.BirthsRepository;
import tk.giaiphapchannuoi.server.repository.MatingsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BirthsService {

    @Autowired
    BirthsRepository birthsRepository;

    @Autowired
    MatingsRepository matingsRepository;

    @Autowired
    UsersService usersService;


    public List<Births> findall(){
        Integer farmId = usersService.getFarmId();
        List<Births> birthsList =  birthsRepository.findAllByDelFlag(false);
        List<Births> temp = new ArrayList<>();
        if (farmId != 0){
            for (Births b :
                    birthsList) {
                //so sanh neu trung farm id thi them vao list moi roi tra ve
                if (b.getMating().getMother().getHouse().getSection().getFarm().getId().equals(farmId)){
                    temp.add(b);
                }
            }
            return temp;
        }else {
            return birthsList;
        }

    }

    public Births findbyid(Integer id){
        Integer farmId = usersService.getFarmId();
        Births births = birthsRepository.findByIdAndDelFlag(id, false).get();
        if (births.getMating().getMother().getHouse().getSection().getFarm().getId().equals(farmId) || farmId == 0){
            return births;
        }else {
            return null;
        }
    }

    @Transactional
    public Births save(Births births){
        Integer farmId = usersService.getFarmId();
        if (births.getMating().getMother().getHouse().getSection().getFarm().getId().equals(farmId) || farmId == 0){
            int dem = 0 ;
            //Lay danh sach birth sau do xem xem heo nai da sinh bao nhieu lan lua lai o bien "dem"
            List<Births> birthsList = findall();
            for (Births temp :
                    birthsList) {
                if(temp.getMating().getMother().getId().equals(births.getMating().getMother().getId())){
                    dem++;
                }
            }
            Matings matings = matingsRepository.findByIdAndDelFlag(births.getMating().getId(),false).get();
            matings.setStatus("borned");
            matingsRepository.save(matings);
            births.setParities(dem);
            births.setDelFlag(false);
            return birthsRepository.save(births);
        }else {
            return null;
        }
    }

    public Births update(Births births){
        Integer farmId = usersService.getFarmId();
        if (births.getMating().getMother().getHouse().getSection().getFarm().getId().equals(farmId) || farmId == 0){
            return birthsRepository.save(births);
        }else {
            return null;
        }
    }

    public Boolean delete(Births births){
        Integer farmId = usersService.getFarmId();
        if (births.getMating().getMother().getHouse().getSection().getFarm().getId().equals(farmId) || farmId == 0){
            births.setDelFlag(true);
            if(birthsRepository.save(births) != null){
                return true;
            }
            return false;
        }else {
            return false;
        }

    }

}
