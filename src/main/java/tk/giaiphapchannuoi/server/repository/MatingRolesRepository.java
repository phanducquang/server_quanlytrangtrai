package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.MatingRoles;

import java.util.List;
import java.util.Optional;

public interface MatingRolesRepository extends JpaRepository<MatingRoles, Integer> {

    Optional<MatingRoles> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<MatingRoles> findAllByDelFlag(Boolean delFlag);
}
