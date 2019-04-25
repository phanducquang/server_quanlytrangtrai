package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.DTO.PigsDTO;

import java.util.List;

public interface PigsDTORepository extends JpaRepository<PigsDTO, Integer> {

    List<PigsDTO> findAllByDelFlag(Boolean delFlag);
}
