package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.IssuesDiseases;

import java.util.List;
import java.util.Optional;

public interface IssuesDiseasesRepository extends JpaRepository<IssuesDiseases, Integer> {

    Optional<IssuesDiseases> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<IssuesDiseases> findAllByDelFlag(Boolean delFlag);
}
