package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.PregnancyStatus;
import tk.giaiphapchannuoi.server.repository.PregnancyStatusRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PregnancyStatusService {

    @Autowired
    PregnancyStatusRepository pregnancyStatusRepository;

    public List<PregnancyStatus> findall(){
        return pregnancyStatusRepository.findAllByDelFlag(false);
    }

    public Optional<PregnancyStatus> findbyid(Integer id){
        return pregnancyStatusRepository.findByIdAndDelFlag(id,false);
    }

    public PregnancyStatus save(PregnancyStatus pregnancyStatus){
        pregnancyStatus.setDelFlag(false);
        return pregnancyStatusRepository.save(pregnancyStatus);
    }

    public PregnancyStatus update(PregnancyStatus pregnancyStatus){
        return pregnancyStatusRepository.save(pregnancyStatus);
    }

    public Boolean delete(PregnancyStatus pregnancyStatus){
        pregnancyStatus.setDelFlag(true);
        if(pregnancyStatusRepository.save(pregnancyStatus) != null){
            return true;
        }
        return false;
    }
}
