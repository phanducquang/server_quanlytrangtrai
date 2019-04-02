package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Births;

import java.util.List;
import java.util.Optional;

public interface BirthsRepository extends JpaRepository<Births, Integer> {

    Optional<Births> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Births> findAllByDelFlag(Boolean delFlag);

}
