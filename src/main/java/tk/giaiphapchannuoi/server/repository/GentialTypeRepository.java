package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.GentialType;

import java.util.List;
import java.util.Optional;

public interface GentialTypeRepository extends JpaRepository<GentialType, Integer> {

    Optional<GentialType> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<GentialType> findAllByDelFlag(Boolean delFlag);
}
