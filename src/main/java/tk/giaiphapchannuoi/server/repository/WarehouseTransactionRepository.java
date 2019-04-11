package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.WarehouseTransaction;

import java.util.List;
import java.util.Optional;

public interface WarehouseTransactionRepository extends JpaRepository<WarehouseTransaction, Integer> {

    Optional<WarehouseTransaction> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<WarehouseTransaction> findAllByDelFlag(Boolean delFlag);
}
