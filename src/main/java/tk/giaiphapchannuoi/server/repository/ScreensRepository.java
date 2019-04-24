package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Screens;

import java.util.List;
import java.util.Optional;

public interface ScreensRepository extends JpaRepository<Screens, Integer> {

    Optional<Screens> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Screens> findAllByDelFlag(Boolean delFlag);
}
