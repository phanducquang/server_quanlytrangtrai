package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.UserRole;
import tk.giaiphapchannuoi.server.repository.UserRoleRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    public List<UserRole> findall(){
        return userRoleRepository.findAllByDelFlag(false);
    }

    public Optional<UserRole> findbyid(Integer id){
        return userRoleRepository.findByIdAndDelFlag(id,false);
    }

    public UserRole save(UserRole userRole){
        return userRoleRepository.save(userRole);
    }

    public Boolean delete(UserRole userRole){
        userRole.setDelFlag(true);
        if(userRoleRepository.save(userRole) != null){
            return true;
        }
        return false;
    }
}
