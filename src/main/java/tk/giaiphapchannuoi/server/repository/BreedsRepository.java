package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Breeds;

import java.util.List;
import java.util.Optional;

public interface BreedsRepository extends JpaRepository<Breeds,Integer> {

    Optional<Breeds> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Breeds> findAllByDelFlag(Boolean delFlag);
}
