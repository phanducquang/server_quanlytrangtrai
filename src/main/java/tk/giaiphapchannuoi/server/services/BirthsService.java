package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Births;
import tk.giaiphapchannuoi.server.repository.BirthsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BirthsService {

    @Autowired
    BirthsRepository birthsRepository;

    public List<Births> findallbirths(){
        return birthsRepository.findAll();
    }

    public Optional<Births> findbyid(Integer id){
        return birthsRepository.findById(id);
    }
}
