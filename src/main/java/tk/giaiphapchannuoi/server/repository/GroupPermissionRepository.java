package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.GroupPermission;

import java.util.List;
import java.util.Optional;

public interface GroupPermissionRepository extends JpaRepository<GroupPermission, Integer> {

    Optional<GroupPermission> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<GroupPermission> findAllByDelFlag(Boolean delFlag);
}
