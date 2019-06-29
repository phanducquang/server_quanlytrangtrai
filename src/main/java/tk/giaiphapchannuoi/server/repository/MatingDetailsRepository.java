package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.MatingDetails;
import tk.giaiphapchannuoi.server.model.Matings;

import java.util.List;
import java.util.Optional;

public interface MatingDetailsRepository extends JpaRepository<MatingDetails, Integer> {

    Optional<MatingDetails> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<MatingDetails> findAllByDelFlag(Boolean delFlag);

    List<MatingDetails> findByMatingAndDelFlag(Matings mating, Boolean delFlag);

}
