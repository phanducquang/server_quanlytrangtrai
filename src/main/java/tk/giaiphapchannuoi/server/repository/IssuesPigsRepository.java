package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.IssuesPigs;

import java.util.List;
import java.util.Optional;

public interface IssuesPigsRepository extends JpaRepository<IssuesPigs, Integer> {

    Optional<IssuesPigs> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<IssuesPigs> findAllByDelFlag(Boolean delFlag);
}
