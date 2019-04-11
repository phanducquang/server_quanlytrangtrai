package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Partners;

import java.util.List;
import java.util.Optional;

public interface PartnersRepository extends JpaRepository<Partners, Integer> {

    Optional<Partners> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Partners> findAllByDelFlag(Boolean delFlag);
}
