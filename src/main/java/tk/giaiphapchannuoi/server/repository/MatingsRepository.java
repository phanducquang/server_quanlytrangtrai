package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Matings;

import java.util.List;
import java.util.Optional;

public interface MatingsRepository extends JpaRepository<Matings, Integer> {

    Optional<Matings> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Matings> findAllByDelFlag(Boolean delFlag);
}
