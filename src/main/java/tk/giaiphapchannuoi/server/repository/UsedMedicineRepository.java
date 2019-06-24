package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.MedicineWarehouse;
import tk.giaiphapchannuoi.server.model.UsedMedicine;

import java.util.List;
import java.util.Optional;

public interface UsedMedicineRepository extends JpaRepository<UsedMedicine, Integer> {

    Optional<UsedMedicine> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<UsedMedicine> findAllByDelFlag(Boolean delFlag);

    List<UsedMedicine> findByMedicineWarehouseAndDelFlag(MedicineWarehouse medicineWarehouse, Boolean delFalg);
}
