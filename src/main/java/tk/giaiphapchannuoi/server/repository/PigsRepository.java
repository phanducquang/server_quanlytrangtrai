package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.HealthStatus;
import tk.giaiphapchannuoi.server.model.Pigs;

import java.util.List;
import java.util.Optional;

public interface PigsRepository extends JpaRepository<Pigs, Integer> {

    Optional<Pigs> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Pigs> findAllByDelFlag(Boolean delFlag);

    List<Pigs> findByHealthStatusAndDelFlag(HealthStatus healthStatus, Boolean delFlag);
}
