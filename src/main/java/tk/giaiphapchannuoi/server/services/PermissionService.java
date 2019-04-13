package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Permisssions;
import tk.giaiphapchannuoi.server.repository.PermissionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    public List<Permisssions> findall(){
        return permissionRepository.findAllByDelFlag(false);
    }

    public Optional<Permisssions> findbyid(Integer id){
        return permissionRepository.findByIdAndDelFlag(id,false);
    }

    public Permisssions save(Permisssions permisssion){
        permisssion.setDelFlag(false);
        return permissionRepository.save(permisssion);
    }

    public Permisssions update(Permisssions permisssion){
        return permissionRepository.save(permisssion);
    }


    public Boolean delete(Permisssions permisssion){
        permisssion.setDelFlag(true);
        if(permissionRepository.save(permisssion) != null){
            return true;
        }
        return false;
    }
}
