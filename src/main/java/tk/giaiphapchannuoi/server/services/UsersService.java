package tk.giaiphapchannuoi.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.giaiphapchannuoi.server.model.Employees;
import tk.giaiphapchannuoi.server.model.Users;
import tk.giaiphapchannuoi.server.repository.EmployeesRepository;
import tk.giaiphapchannuoi.server.repository.UsersRepository;
import tk.giaiphapchannuoi.server.security.JwtAuthenticationFilter;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EmployeesRepository employeesRepository;

    public Integer getFarmId(){
        //Lay userId thong qua bien public từ class JwtAuthenticationFilter
        //Xac dinh farm id bang cach lay thong tin user => lay thong tin employee => lay thong tin farm
        Users user = findbyid(JwtAuthenticationFilter.userIdGlobal).get();
        Integer farmId = user.getEmployee().getFarm().getId();
        return farmId;
    }

    public List<Users> findall(){
        return usersRepository.findAllByDelFlag(false);
    }

    public Optional<Users> findbyid(Integer id){
        return usersRepository.findByIdAndDelFlag(id,false);
    }

    public Optional<Users> findbyusername(String username){
        return usersRepository.findByUsernameAndDelFlag(username,false);
    }

    public List<Users> findbyemployee(Integer employeeId){
        Optional<Employees> employee = employeesRepository.findByIdAndDelFlag(employeeId, false);
        if (employee.isPresent()){
            return usersRepository.findByEmployeeAndDelFlag(employee.get(),false);
        }
        return Collections.emptyList();
//        return employee.map(e -> usersRepository.findByEmployeeAndDelFlag(e,false)).orElse(Collections.emptyList());
    }

    public Users save(Users user){
        user.setDelFlag(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }

    public Users updatePassword(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }

    public Users update(Users user){
        return usersRepository.save(user);
    }

    public Users updateTokenNotification(Integer userId, String token){
        Optional<Users> user = findbyid(userId);
        if (user.isPresent()){
            user.get().setTokenNotification(token);
            return usersRepository.save(user.get());
        }
        return null;
    }

    public Boolean delete(Users user){
        user.setDelFlag(true);
        if(usersRepository.save(user) != null){
            return true;
        }
        return false;
    }
}
