package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.HealthStatus;
import tk.giaiphapchannuoi.server.repository.HealthStatusRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HealthStatusService {

    @Autowired
    HealthStatusRepository healthStatusRepository;

    public List<HealthStatus> findall(){
        return healthStatusRepository.findAllByDelFlag(false);
    }

    public Optional<HealthStatus> findbyid(Integer id){
        return healthStatusRepository.findByIdAndDelFlag(id,false);
    }

    public HealthStatus save(HealthStatus healthStatus){
        return healthStatusRepository.save(healthStatus);
    }

    public Boolean delete(HealthStatus healthStatus){
        healthStatus.setDelFlag(true);
        if(healthStatusRepository.save(healthStatus) != null){
            return true;
        }
        return false;
    }
}
