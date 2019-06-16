package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Employees;
import tk.giaiphapchannuoi.server.model.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    Optional<Schedule> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Schedule> findAllByDelFlag(Boolean delFlag);

    List<Schedule> findByEmployeeAndDelFlag(Employees employee, Boolean delFlag);
}
