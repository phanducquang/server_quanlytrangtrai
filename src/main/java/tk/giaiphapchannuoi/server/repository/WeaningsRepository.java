package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Weanings;

import java.util.List;
import java.util.Optional;

public interface WeaningsRepository extends JpaRepository<Weanings, Integer> {

    Optional<Weanings> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Weanings> findAllByDelFlag(Boolean delFlag);
}
