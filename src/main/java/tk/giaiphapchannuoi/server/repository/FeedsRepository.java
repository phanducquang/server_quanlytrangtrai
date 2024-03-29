package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Feeds;
import tk.giaiphapchannuoi.server.model.FoodWarehouse;

import java.util.List;
import java.util.Optional;

public interface FeedsRepository extends JpaRepository<Feeds, Integer> {

    Optional<Feeds> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Feeds> findAllByDelFlag(Boolean delFlag);

    List<Feeds> findByFoodWarehouseAndDelFlag(FoodWarehouse foodWarehouse, Boolean delFlag);
}
