package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.GroupLogs;

import java.util.List;
import java.util.Optional;

public interface GroupLogsRepository extends JpaRepository<GroupLogs, Integer> {

    Optional<GroupLogs> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<GroupLogs> findAllByDelFlag(Boolean delFlag);
}
