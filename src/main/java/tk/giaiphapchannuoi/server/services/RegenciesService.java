package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Regencies;
import tk.giaiphapchannuoi.server.repository.RegenciesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RegenciesService {

    @Autowired
    RegenciesRepository regenciesRepository;

    public List<Regencies> findall(){
        return regenciesRepository.findAllByDelFlag(false);
    }

    public Optional<Regencies> findbyid(Integer id){
        return regenciesRepository.findByIdAndDelFlag(id,false);
    }

    public Regencies save(Regencies regency){
        regency.setDelFlag(false);
        return regenciesRepository.save(regency);
    }

    public Regencies update(Regencies regency){
        return regenciesRepository.save(regency);
    }


    public Boolean delete(Regencies regency){
        regency.setDelFlag(true);
        if(regenciesRepository.save(regency) != null){
            return true;
        }
        return false;
    }
}
