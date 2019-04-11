package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Warehouses;

import java.util.List;
import java.util.Optional;

public interface WarehousesRepository extends JpaRepository<Warehouses, Integer> {

    Optional<Warehouses> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Warehouses> findAllByDelFlag(Boolean delFlag);
}
