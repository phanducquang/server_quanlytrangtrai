package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.MatingRoles;
import tk.giaiphapchannuoi.server.repository.MatingRolesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MatingRolesService {

    @Autowired
    MatingRolesRepository matingRolesRepository;

    public List<MatingRoles> findall(){
        return matingRolesRepository.findAllByDelFlag(false);
    }

    public Optional<MatingRoles> findbyid(Integer id){
        return matingRolesRepository.findByIdAndDelFlag(id,false);
    }

    public MatingRoles save(MatingRoles matingRole){
        return matingRolesRepository.save(matingRole);
    }

    public Boolean delete(MatingRoles matingRole){
        matingRole.setDelFlag(true);
        if(matingRolesRepository.save(matingRole) != null){
            return true;
        }
        return false;
    }
}
