package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Cages;

import java.util.List;
import java.util.Optional;

public interface CagesRepository extends JpaRepository<Cages, Integer> {

    Optional<Cages> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Cages> findAllByDelFlag(Boolean delFlag);
}
