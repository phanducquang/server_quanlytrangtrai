package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.FoodWarehouse;
import tk.giaiphapchannuoi.server.model.InvoicesProduct;

import java.util.List;
import java.util.Optional;

public interface FoodWarehouseRepository extends JpaRepository<FoodWarehouse, Integer> {

    Optional<FoodWarehouse> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<FoodWarehouse> findAllByDelFlag(Boolean delFlag);

    List<FoodWarehouse> findByInvoiceAndDelFlag(InvoicesProduct invoicesProduct, Boolean delFlag);
}
