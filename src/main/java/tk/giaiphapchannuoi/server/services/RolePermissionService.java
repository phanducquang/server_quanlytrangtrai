package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Permissions;
import tk.giaiphapchannuoi.server.model.RolePermission;
import tk.giaiphapchannuoi.server.model.Roles;
import tk.giaiphapchannuoi.server.repository.RolePermissionRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RolePermissionService {

    @Autowired
    RolePermissionRepository rolePermissionRepository;

    @Autowired
    RolesService rolesService;

    public List<RolePermission> findall(){
        return rolePermissionRepository.findAllByDelFlag(false);
    }

    public Optional<RolePermission> findbyid(Integer id){
        return rolePermissionRepository.findByIdAndDelFlag(id,false);
    }

    public List<Permissions> findbyrole(Integer id){
        Optional<Roles> role = rolesService.findbyid(id);
        if (role.isPresent()){
            List<RolePermission> rolePermissionList = rolePermissionRepository.findAllByRoleAndDelFlag(role.get(),false);
            List<Permissions> permissionsList = new ArrayList<>();
            for (RolePermission rp :
                    rolePermissionList) {
                permissionsList.add(rp.getPermission());
            }
            return permissionsList;
        }
        return Collections.emptyList();
    }

    @Transactional
    public List<RolePermission> save(List<RolePermission> rolePermission){
        List<RolePermission> temp = new ArrayList<>();
        for (RolePermission rp:
             rolePermission) {
            rp.setDelFlag(false);
            temp.add(rolePermissionRepository.save(rp));
        }
        return temp;
    }

    public List<RolePermission> update(List<RolePermission> rolePermission){
        Optional<Roles> role = rolesService.findbyid(rolePermission.get(0).getRole().getId());
        if (role.isPresent()){
            rolePermissionRepository.deleteByRole(role.get());
            return save(rolePermission);
        }
        return Collections.emptyList();
    }


    public Boolean delete(RolePermission rolePermission){
        rolePermission.setDelFlag(true);
        if(rolePermissionRepository.save(rolePermission) != null){
            return true;
        }
        return false;
    }
}
