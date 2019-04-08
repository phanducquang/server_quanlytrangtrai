package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Farms;

import java.util.List;
import java.util.Optional;

public interface FarmsRepository extends JpaRepository<Farms, Integer> {

    Optional<Farms> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Farms> findAllByDelFlag(Boolean delFlag);
}
