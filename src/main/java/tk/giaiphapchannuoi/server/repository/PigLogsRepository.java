package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.PigLogs;

import java.util.List;
import java.util.Optional;

public interface PigLogsRepository extends JpaRepository<PigLogs, Integer> {

    Optional<PigLogs> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<PigLogs> findAllByDelFlag(Boolean delFlag);
}
