package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.InvoicePigDetail;

import java.util.List;
import java.util.Optional;

public interface InvoicePigDetailRepository extends JpaRepository<InvoicePigDetail, Integer> {

    Optional<InvoicePigDetail> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<InvoicePigDetail> findAllByDelFlag(Boolean delFlag);
}
