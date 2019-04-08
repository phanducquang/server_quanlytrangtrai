package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.FarmTypes;

import java.util.List;
import java.util.Optional;

public interface FarmTypesRepository extends JpaRepository<FarmTypes, Integer> {

    Optional<FarmTypes> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<FarmTypes> findAllByDelFlag(Boolean delFlag);
}
