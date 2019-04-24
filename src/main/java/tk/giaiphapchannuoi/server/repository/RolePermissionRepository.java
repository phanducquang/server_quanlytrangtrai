package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.RolePermission;
import tk.giaiphapchannuoi.server.model.Roles;

import java.util.List;
import java.util.Optional;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer> {

    Optional<RolePermission> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<RolePermission> findAllByDelFlag(Boolean delFlag);

    List<RolePermission> findAllByRoleAndDelFlag(Roles role, Boolean delFlag);
}
