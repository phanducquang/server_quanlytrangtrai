package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.ObjectType;

import java.util.List;
import java.util.Optional;

public interface ObjectTypeRepository extends JpaRepository<ObjectType, Integer> {

    Optional<ObjectType> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<ObjectType> findAllByDelFlag(Boolean delFlag);
}
