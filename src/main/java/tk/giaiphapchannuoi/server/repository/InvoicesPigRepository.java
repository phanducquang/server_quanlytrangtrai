package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.InvoicesPig;

import java.util.List;
import java.util.Optional;

public interface InvoicesPigRepository extends JpaRepository<InvoicesPig, Integer> {

    Optional<InvoicesPig> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<InvoicesPig> findAllByDelFlag(Boolean delFlag);
}
