package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Issues;

import java.util.List;
import java.util.Optional;

public interface IssuesRepository extends JpaRepository<Issues, Integer> {

    Optional<Issues> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Issues> findAllByDelFlag(Boolean delFlag);
}
