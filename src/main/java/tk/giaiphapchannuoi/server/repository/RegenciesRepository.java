package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Regencies;

import java.util.List;
import java.util.Optional;

public interface RegenciesRepository extends JpaRepository<Regencies, Integer> {

    Optional<Regencies> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Regencies> findAllByDelFlag(Boolean delFlag);
}
