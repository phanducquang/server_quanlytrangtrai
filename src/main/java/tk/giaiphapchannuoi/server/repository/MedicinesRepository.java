package tk.giaiphapchannuoi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.giaiphapchannuoi.server.model.Medicines;

import java.util.List;
import java.util.Optional;

public interface MedicinesRepository extends JpaRepository<Medicines, Integer> {

    Optional<Medicines> findByIdAndDelFlag(Integer id, Boolean delFlag);

    List<Medicines> findAllByDelFlag(Boolean delFlag);
}
