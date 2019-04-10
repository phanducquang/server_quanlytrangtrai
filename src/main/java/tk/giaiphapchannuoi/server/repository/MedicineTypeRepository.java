package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.MedicineType;

import java.util.List;
import java.util.Optional;

public interface MedicineTypeRepository extends JpaRepository<MedicineType, Integer> {

    Optional<MedicineType> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<MedicineType> findAllByDelFlag(Boolean delFlag);
}
