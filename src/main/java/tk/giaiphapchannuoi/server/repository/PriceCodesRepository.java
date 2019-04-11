package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.PriceCodes;

import java.util.List;
import java.util.Optional;

public interface PriceCodesRepository extends JpaRepository<PriceCodes, Integer> {

    Optional<PriceCodes> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<PriceCodes> findAllByDelFlag(Boolean delFlag);
}
