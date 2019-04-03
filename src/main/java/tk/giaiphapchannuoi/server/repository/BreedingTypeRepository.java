package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.BreedingType;

import java.util.List;
import java.util.Optional;

public interface BreedingTypeRepository extends JpaRepository<BreedingType, Integer> {

    Optional<BreedingType> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<BreedingType> findAllByDelFlag(Boolean delFlag);
}
