package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.InvoicesProduct;
import tk.giaiphapchannuoi.server.model.MedicineWarehouse;

import java.util.List;
import java.util.Optional;

public interface MedicineWarehouseRepository extends JpaRepository<MedicineWarehouse, Integer> {

    Optional<MedicineWarehouse> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<MedicineWarehouse> findAllByDelFlag(Boolean delFlag);

    List<MedicineWarehouse> findByInvoiceAndDelFlag(InvoicesProduct invoicesProduct, Boolean delFlag);
}
