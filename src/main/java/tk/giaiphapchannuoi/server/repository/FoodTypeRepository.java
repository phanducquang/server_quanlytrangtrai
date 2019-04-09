package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.FoodType;

import java.util.List;
import java.util.Optional;

public interface FoodTypeRepository extends JpaRepository<FoodType, Integer> {

    Optional<FoodType> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<FoodType> findAllByDelFlag(Boolean delFlag);
}
