package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Diseases;

import java.util.List;
import java.util.Optional;

public interface DiseasesRepository extends JpaRepository<Diseases, Integer> {

    Optional<Diseases> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Diseases> findAllByDelFlag(Boolean delFlag);
}
