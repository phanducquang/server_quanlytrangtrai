package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.FootType;

import java.util.List;
import java.util.Optional;

public interface FootTypeRepository extends JpaRepository<FootType, Integer> {

    Optional<FootType> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<FootType> findAllByDelFlag(Boolean delFlag);
}
