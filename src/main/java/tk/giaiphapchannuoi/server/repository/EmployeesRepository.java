package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Employees;

import java.util.List;
import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {

    Optional<Employees> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Employees> findAllByDelFlag(Boolean delFlag);

    Optional<Employees> findByEmailAndDelFlag(String email, Boolean delFlag);
}
