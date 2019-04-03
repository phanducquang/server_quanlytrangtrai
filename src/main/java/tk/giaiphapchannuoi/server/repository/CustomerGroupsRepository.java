package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.CustomerGroups;

import java.util.List;
import java.util.Optional;

public interface CustomerGroupsRepository extends JpaRepository<CustomerGroups, Integer> {

    Optional<CustomerGroups> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<CustomerGroups> findAllByDelFlag(Boolean delFlag);
}
