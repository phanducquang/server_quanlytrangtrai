package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Houses;
import tk.giaiphapchannuoi.server.repository.HousesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HousesService {

    @Autowired
    HousesRepository housesRepository;

    public List<Houses> findall(){
        return housesRepository.findAllByDelFlag(false);
    }

    public Optional<Houses> findbyid(Integer id){
        return housesRepository.findByIdAndDelFlag(id,false);
    }

    public Houses save(Houses house){
        return housesRepository.save(house);
    }

    public Boolean delete(Houses house){
        house.setDelFlag(true);
        if(housesRepository.save(house) != null){
            return true;
        }
        return false;
    }
}
