package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.InvoicesProduct;

import java.util.List;
import java.util.Optional;

public interface InvoicesProductRepository extends JpaRepository<InvoicesProduct, Integer> {

    Optional<InvoicesProduct> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<InvoicesProduct> findAllByDelFlag(Boolean delFlag);
}
