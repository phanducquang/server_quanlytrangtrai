package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Permissions;
import tk.giaiphapchannuoi.server.repository.PermissionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    public List<Permissions> findall(){
        return permissionRepository.findAllByDelFlag(false);
    }

    public Optional<Permissions> findbyid(Integer id){
        return permissionRepository.findByIdAndDelFlag(id,false);
    }

    public Permissions save(Permissions permisssion){
        permisssion.setDelFlag(false);
        return permissionRepository.save(permisssion);
    }

    public Permissions update(Permissions permisssion){
        return permissionRepository.save(permisssion);
    }


    public Boolean delete(Permissions permisssion){
        permisssion.setDelFlag(true);
        if(permissionRepository.save(permisssion) != null){
            return true;
        }
        return false;
    }
}
