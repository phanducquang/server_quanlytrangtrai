package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Breedings;
import tk.giaiphapchannuoi.server.model.Pigs;

import java.util.List;
import java.util.Optional;

public interface BreedingsRepository extends JpaRepository<Breedings, Integer> {

    Optional<Breedings> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Breedings> findAllByDelFlag(Boolean delFlag);

    List<Breedings> findByPigAndAndDelFlag(Pigs pig, Boolean delFlag);
}
