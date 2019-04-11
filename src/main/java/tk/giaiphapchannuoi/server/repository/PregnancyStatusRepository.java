package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.PregnancyStatus;

import java.util.List;
import java.util.Optional;

public interface PregnancyStatusRepository extends JpaRepository<PregnancyStatus, Integer> {

    Optional<PregnancyStatus> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<PregnancyStatus> findAllByDelFlag(Boolean delFlag);
}
