package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Spays;

import java.util.List;
import java.util.Optional;

public interface SpaysRepository extends JpaRepository<Spays, Integer> {

    Optional<Spays> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Spays> findAllByDelFlag(Boolean delFlag);
}
