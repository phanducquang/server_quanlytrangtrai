package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Employees;
import tk.giaiphapchannuoi.server.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Users> findAllByDelFlag(Boolean delFlag);

    Optional<Users> findByUsernameAndDelFlag(String username, Boolean delFlag);

    List<Users> findByEmployeeAndDelFlag(Employees employee, Boolean delFlag);
}
