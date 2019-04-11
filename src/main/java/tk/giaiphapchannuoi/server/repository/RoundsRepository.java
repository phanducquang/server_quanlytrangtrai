package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Rounds;

import java.util.List;
import java.util.Optional;

public interface RoundsRepository extends JpaRepository<Rounds, Integer> {

    Optional<Rounds> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Rounds> findAllByDelFlag(Boolean delFlag);
}
