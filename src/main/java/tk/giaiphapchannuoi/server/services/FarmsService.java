package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Farms;
import tk.giaiphapchannuoi.server.repository.FarmsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FarmsService {

    @Autowired
    FarmsRepository farmsRepository;

    public List<Farms> findall(){
        return farmsRepository.findAllByDelFlag(false);
    }

    public Optional<Farms> findbyid(Integer id){
        return farmsRepository.findByIdAndDelFlag(id,false);
    }

    public Farms save(Farms farm){
        return farmsRepository.save(farm);
    }

    public Boolean delete(Farms farm){
        farm.setDelFlag(true);
        if(farmsRepository.save(farm) != null){
            return true;
        }
        return false;
    }
}
