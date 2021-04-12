package com.assigment.hospital.repository;

import com.assigment.hospital.entity.NhanvienEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanvienRepository extends JpaRepository<NhanvienEntity, Long> {
    
}
