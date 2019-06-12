package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.DTO.PigsDTO;

import java.util.List;
import java.util.Optional;

public interface PigsDTORepository extends JpaRepository<PigsDTO, Integer> {

    List<PigsDTO> findAllByDelFlag(Boolean delFlag);

    Optional<PigsDTO> findByIdAndDelFlag(Integer id, Boolean delFlag);
}
