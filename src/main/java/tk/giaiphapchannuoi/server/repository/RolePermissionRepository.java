package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.RolePermission;

import java.util.List;
import java.util.Optional;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer> {

    Optional<RolePermission> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<RolePermission> findAllByDelFlag(Boolean delFlag);
}
