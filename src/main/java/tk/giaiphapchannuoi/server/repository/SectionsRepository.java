package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Sections;

import java.util.List;
import java.util.Optional;

public interface SectionsRepository extends JpaRepository<Sections, Integer> {

    Optional<Sections> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Sections> findAllByDelFlag(Boolean delFlag);
}
