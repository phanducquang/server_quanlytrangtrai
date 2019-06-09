package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.DTO.Pigs1DTO;

import java.util.List;
import java.util.Optional;

public interface Pigs1DTORepository extends JpaRepository<Pigs1DTO, Integer> {

    List<Pigs1DTO> findAllByDelFlag(Boolean delFlag);

    Optional<Pigs1DTO> findByIdAndDelFlag(Integer id, Boolean delFlag);
}
