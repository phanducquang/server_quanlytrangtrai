package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Permissions;

import java.util.List;
import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permissions, Integer> {

    Optional<Permissions> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Permissions> findAllByDelFlag(Boolean delFlag);

}
