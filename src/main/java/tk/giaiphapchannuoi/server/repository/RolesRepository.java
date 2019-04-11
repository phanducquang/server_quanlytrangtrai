package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Roles;

import java.util.List;
import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Integer> {

    Optional<Roles> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Roles> findAllByDelFlag(Boolean delFlag);
}
