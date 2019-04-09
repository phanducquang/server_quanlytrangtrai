package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Houses;

import java.util.List;
import java.util.Optional;

public interface HousesRepository extends JpaRepository<Houses, Integer> {

    Optional<Houses> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Houses> findAllByDelFlag(Boolean delFlag);
}
