package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.DTO.PigsDTO;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.repository.PigsDTORepository;
import tk.giaiphapchannuoi.server.repository.PigsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PigsService {

    @Autowired
    PigsRepository pigsRepository;

    @Autowired
    PigsDTORepository pigsDTORepository;

    public List<PigsDTO> findall(){
        return pigsDTORepository.findAllByDelFlag(false);
    }

    public Optional<Pigs> findbyid(Integer id){
        return pigsRepository.findByIdAndDelFlag(id,false);
    }

    public Pigs save(Pigs pig){
        pig.setDelFlag(false);
        return pigsRepository.save(pig);
    }

    public Pigs update(Pigs pig){
        return pigsRepository.save(pig);
    }


    public Boolean delete(Pigs pig){
        pig.setDelFlag(true);
        if(pigsRepository.save(pig) != null){
            return true;
        }
        return false;
    }
}
