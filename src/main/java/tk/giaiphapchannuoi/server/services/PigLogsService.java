package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.PigLogs;
import tk.giaiphapchannuoi.server.repository.PigLogsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PigLogsService {

    @Autowired
    PigLogsRepository pigLogsRepository;

    public List<PigLogs> findall(){
        return pigLogsRepository.findAllByDelFlag(false);
    }

    public Optional<PigLogs> findbyid(Integer id){
        return pigLogsRepository.findByIdAndDelFlag(id,false);
    }

    public PigLogs save(PigLogs pigLog){
        return pigLogsRepository.save(pigLog);
    }

    public Boolean delete(PigLogs pigLog){
        pigLog.setDelFlag(true);
        if(pigLogsRepository.save(pigLog) != null){
            return true;
        }
        return false;
    }
}
