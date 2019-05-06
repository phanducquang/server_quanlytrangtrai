package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.FoodUnits;

import java.util.List;
import java.util.Optional;

public interface FoodUnitsRepository extends JpaRepository<FoodUnits, Integer> {

    Optional<FoodUnits> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<FoodUnits> findAllByDelFlag(Boolean delFlag);
}
