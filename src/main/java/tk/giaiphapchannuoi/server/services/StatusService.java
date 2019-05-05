package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Status;
import tk.giaiphapchannuoi.server.repository.StatusRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StatusService {

    @Autowired
    StatusRepository statusRepository;

    public List<Status> findall(){
        return statusRepository.findAllByDelFlag(false);
    }

    public Optional<Status> findbyid(Integer id){
        return statusRepository.findByIdAndDelFlag(id,false);
    }

    public Status save(Status sperm){
        sperm.setDelFlag(false);
        return statusRepository.save(sperm);
    }

    public Status update(Status sperm){
        return statusRepository.save(sperm);
    }

    public Boolean delete(Status sperm){
        sperm.setDelFlag(true);
        if(statusRepository.save(sperm) != null){
            return true;
        }
        return false;
    }
}
