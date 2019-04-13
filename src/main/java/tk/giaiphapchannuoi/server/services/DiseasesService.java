package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Diseases;
import tk.giaiphapchannuoi.server.repository.DiseasesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DiseasesService {

    @Autowired
    DiseasesRepository diseasesRepository;

    public List<Diseases> findall(){
        return diseasesRepository.findAllByDelFlag(false);
    }

    public Optional<Diseases> findbyid(Integer id){
        return diseasesRepository.findByIdAndDelFlag(id,false);
    }

    public Diseases save(Diseases diseases){
        diseases.setDelFlag(false);
        return diseasesRepository.save(diseases);
    }

    public Diseases update(Diseases diseases){
        return diseasesRepository.save(diseases);
    }

    public Boolean delete(Diseases diseases){
        diseases.setDelFlag(true);
        if(diseasesRepository.save(diseases) != null){
            return true;
        }
        return false;
    }
}
