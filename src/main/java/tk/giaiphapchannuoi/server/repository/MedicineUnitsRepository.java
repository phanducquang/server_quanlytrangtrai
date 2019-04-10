package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.MedicineUnits;

import java.util.List;
import java.util.Optional;

public interface MedicineUnitsRepository extends JpaRepository<MedicineUnits, Integer> {

    Optional<MedicineUnits> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<MedicineUnits> findAllByDelFlag(Boolean delFlag);
}
