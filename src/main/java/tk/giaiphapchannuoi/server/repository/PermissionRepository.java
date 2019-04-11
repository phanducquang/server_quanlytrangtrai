package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Permisssions;

import java.util.List;
import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permisssions, Integer> {

    Optional<Permisssions> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Permisssions> findAllByDelFlag(Boolean delFlag);
}
