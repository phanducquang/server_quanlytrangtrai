package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Groups;

import java.util.List;
import java.util.Optional;

public interface GroupsRepository extends JpaRepository<Groups, Integer> {

    Optional<Groups> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Groups> findAllByDelFlag(Boolean delFlag);
}
