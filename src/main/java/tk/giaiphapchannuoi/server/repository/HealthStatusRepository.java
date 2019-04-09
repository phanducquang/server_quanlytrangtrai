package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.HealthStatus;

import java.util.List;
import java.util.Optional;

public interface HealthStatusRepository extends JpaRepository<HealthStatus, Integer> {

    Optional<HealthStatus> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<HealthStatus> findAllByDelFlag(Boolean delFlag);
}
