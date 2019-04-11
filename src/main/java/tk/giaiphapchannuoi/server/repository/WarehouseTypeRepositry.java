package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.WarehouseType;

import java.util.List;
import java.util.Optional;

public interface WarehouseTypeRepositry extends JpaRepository<WarehouseType, Integer> {

    Optional<WarehouseType> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<WarehouseType> findAllByDelFlag(Boolean delFlag);
}
