package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Groups;
import tk.giaiphapchannuoi.server.repository.GroupsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GroupsService {

    @Autowired
    GroupsRepository groupsRepository;

    public List<Groups> findall(){
        return groupsRepository.findAllByDelFlag(false);
    }

    public Optional<Groups> findbyid(Integer id){
        return groupsRepository.findByIdAndDelFlag(id,false);
    }

    public Groups save(Groups group){
        group.setDelFlag(false);
        return groupsRepository.save(group);
    }

    public Groups update(Groups group){
        return groupsRepository.save(group);
    }


    public Boolean delete(Groups group){
        group.setDelFlag(true);
        if(groupsRepository.save(group) != null){
            return true;
        }
        return false;
    }
}
