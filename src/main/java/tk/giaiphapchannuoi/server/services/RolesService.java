package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Roles;
import tk.giaiphapchannuoi.server.repository.RolesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RolesService {

    @Autowired
    RolesRepository rolesRepository;

    public List<Roles> findall(){
        return rolesRepository.findAllByDelFlag(false);
    }

    public Optional<Roles> findbyid(Integer id){
        return rolesRepository.findByIdAndDelFlag(id,false);
    }

    public Roles save(Roles role){
        role.setDelFlag(false);
        return rolesRepository.save(role);
    }

    public Roles update(Roles role){
        return rolesRepository.save(role);
    }


    public Boolean delete(Roles role){
        role.setDelFlag(true);
        if(rolesRepository.save(role) != null){
            return true;
        }
        return false;
    }
}
