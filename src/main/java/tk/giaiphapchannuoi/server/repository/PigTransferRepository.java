package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.PigTransfer;
import tk.giaiphapchannuoi.server.model.Pigs;

import java.util.List;
import java.util.Optional;

public interface PigTransferRepository extends JpaRepository<PigTransfer, Integer> {

    Optional<PigTransfer> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<PigTransfer> findByPigAndStatusAndDelFlag(Pigs pig, String status, Boolean delFlag);

    List<PigTransfer> findByPigAndDelFlag(Pigs pig, Boolean delFlag);

    List<PigTransfer> findByStatusAndDelFlag(String status, Boolean delFlag);

    List<PigTransfer> findAllByDelFlag(Boolean delFlag);

}
