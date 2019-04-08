package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.CustomerTypes;

import java.util.List;
import java.util.Optional;

public interface CustomerTypesRepository extends JpaRepository<CustomerTypes, Integer> {

    Optional<CustomerTypes> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<CustomerTypes> findAllByDelFlag(Boolean delFlag);
}
