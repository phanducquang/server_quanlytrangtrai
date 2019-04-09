package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.InvoicesProductDetail;

import java.util.List;
import java.util.Optional;

public interface InvoicesProductDetailRepository extends JpaRepository<InvoicesProductDetail, Integer> {

    Optional<InvoicesProductDetail> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<InvoicesProductDetail> findAllByDelFlag(Boolean delFlag);
}
