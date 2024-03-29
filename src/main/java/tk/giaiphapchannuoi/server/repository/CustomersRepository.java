package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Customers;

import java.util.List;
import java.util.Optional;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {

    Optional<Customers> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Customers> findAllByDelFlag(Boolean delFlag);
}
