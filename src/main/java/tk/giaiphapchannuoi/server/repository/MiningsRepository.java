package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Minings;

import java.util.List;
import java.util.Optional;

public interface MiningsRepository extends JpaRepository<Minings, Integer> {

    Optional<Minings> findById(Integer id);

    List<Minings> findAll();
}
