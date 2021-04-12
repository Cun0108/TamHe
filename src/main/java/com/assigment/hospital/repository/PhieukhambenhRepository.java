package com.assigment.hospital.repository;

import com.assigment.hospital.entity.PhieukhambenhEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhieukhambenhRepository extends JpaRepository<PhieukhambenhEntity, Long> {
    List<PhieukhambenhEntity> findByMabn(long mabn);
}
