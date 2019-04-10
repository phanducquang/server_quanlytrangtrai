package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.MedicineDisease;

import java.util.List;
import java.util.Optional;

public interface MedicineDiseaseRepository extends JpaRepository<MedicineDisease, Integer> {

    Optional<MedicineDisease> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<MedicineDisease> findAllByDelFlag(Boolean delFlag);
}
