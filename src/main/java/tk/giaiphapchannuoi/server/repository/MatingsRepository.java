package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Matings;
import tk.giaiphapchannuoi.server.model.Pigs;

import java.util.List;
import java.util.Optional;

public interface MatingsRepository extends JpaRepository<Matings, Integer> {

    Optional<Matings> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Matings> findAllByDelFlag(Boolean delFlag);

    List<Matings> findByMotherOrFatherIdAndDelFlag(Pigs mother, Integer fatherId, Boolean delFlag);

    List<Matings> findByMotherAndDelFlag(Pigs mother, Boolean delFlag);

    List<Matings> findByFatherIdAndDelFlag(Integer father, Boolean delFlag);
}
