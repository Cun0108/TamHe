package com.assigment.hospital.repository;

import com.assigment.hospital.entity.DonthuocEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonthuocRepository extends JpaRepository<DonthuocEntity, Long> {
    List<DonthuocEntity> findAllByMabn(Long mabn);
    List<DonthuocEntity> findByMabnAndThuocContains(Long mabn, String thuoc);
}
