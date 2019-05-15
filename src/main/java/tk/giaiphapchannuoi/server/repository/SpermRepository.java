package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Pigs;
import tk.giaiphapchannuoi.server.model.Sperm;

import java.util.List;
import java.util.Optional;

public interface SpermRepository extends JpaRepository<Sperm, Integer> {

    Optional<Sperm> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Sperm> findAllByDelFlag(Boolean delFlag);

    List<Sperm> findByPigAndDelFlag(Pigs pig, Boolean delFlag);
}
