package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Users;
import tk.giaiphapchannuoi.server.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public List<Users> findall(){
        return usersRepository.findAllByDelFlag(false);
    }

    public Optional<Users> findbyid(Integer id){
        return usersRepository.findByIdAndDelFlag(id,false);
    }

    public Users save(Users user){
        return usersRepository.save(user);
    }

    public Boolean delete(Users user){
        user.setDelFlag(true);
        if(usersRepository.save(user) != null){
            return true;
        }
        return false;
    }
}
