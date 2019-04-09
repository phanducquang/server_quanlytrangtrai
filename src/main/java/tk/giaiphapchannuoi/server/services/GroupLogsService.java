package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.GroupLogs;
import tk.giaiphapchannuoi.server.repository.GroupLogsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GroupLogsService {

    @Autowired
    GroupLogsRepository groupLogsRepository;

    public List<GroupLogs> findall(){
        return groupLogsRepository.findAllByDelFlag(false);
    }

    public Optional<GroupLogs> findbyid(Integer id){
        return groupLogsRepository.findByIdAndDelFlag(id,false);
    }

    public GroupLogs save(GroupLogs groupLog){
        return groupLogsRepository.save(groupLog);
    }

    public Boolean delete(GroupLogs groupLog){
        groupLog.setDelFlag(true);
        if(groupLogsRepository.save(groupLog) != null){
            return true;
        }
        return false;
    }
}
