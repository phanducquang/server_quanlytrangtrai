package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.GroupPermission;
import tk.giaiphapchannuoi.server.repository.GroupPermissionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GroupPermissionService {

    @Autowired
    GroupPermissionRepository groupPermissionRepository;

    public List<GroupPermission> findall(){
        return groupPermissionRepository.findAllByDelFlag(false);
    }

    public Optional<GroupPermission> findbyid(Integer id){
        return groupPermissionRepository.findByIdAndDelFlag(id,false);
    }

    public GroupPermission save(GroupPermission groupPermission){
        return groupPermissionRepository.save(groupPermission);
    }

    public Boolean delete(GroupPermission groupPermission){
        groupPermission.setDelFlag(true);
        if(groupPermissionRepository.save(groupPermission) != null){
            return true;
        }
        return false;
    }
}
