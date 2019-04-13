package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.RolePermission;
import tk.giaiphapchannuoi.server.repository.RolePermissionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RolePermissionService {

    @Autowired
    RolePermissionRepository rolePermissionRepository;

    public List<RolePermission> findall(){
        return rolePermissionRepository.findAllByDelFlag(false);
    }

    public Optional<RolePermission> findbyid(Integer id){
        return rolePermissionRepository.findByIdAndDelFlag(id,false);
    }

    public RolePermission save(RolePermission rolePermission){
        rolePermission.setDelFlag(false);
        return rolePermissionRepository.save(rolePermission);
    }

    public RolePermission update(RolePermission rolePermission){
        return rolePermissionRepository.save(rolePermission);
    }


    public Boolean delete(RolePermission rolePermission){
        rolePermission.setDelFlag(true);
        if(rolePermissionRepository.save(rolePermission) != null){
            return true;
        }
        return false;
    }
}
