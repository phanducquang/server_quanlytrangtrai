package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Foods;

import java.util.List;
import java.util.Optional;

public interface FoodsRepository extends JpaRepository<Foods, Integer> {

    Optional<Foods> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Foods> findAllByDelFlag(Boolean delFlag);
}
