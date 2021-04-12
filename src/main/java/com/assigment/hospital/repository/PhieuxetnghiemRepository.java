package com.assigment.hospital.repository;

import java.util.List;

import com.assigment.hospital.entity.PhieuxetnghiemEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuxetnghiemRepository extends JpaRepository<PhieuxetnghiemEntity, Long> {
    List<PhieuxetnghiemEntity> findByMabn(long mabn);
}
