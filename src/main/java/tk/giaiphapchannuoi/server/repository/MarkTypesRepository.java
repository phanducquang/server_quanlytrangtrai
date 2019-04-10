package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.MarkTypes;

import java.util.List;
import java.util.Optional;

public interface MarkTypesRepository extends JpaRepository<MarkTypes, Integer> {

    Optional<MarkTypes> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<MarkTypes> findAllByDelFlag(Boolean delFlag);
}
