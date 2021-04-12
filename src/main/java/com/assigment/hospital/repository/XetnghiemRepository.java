package com.assigment.hospital.repository;

import com.assigment.hospital.entity.XetnghiemEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XetnghiemRepository extends JpaRepository<XetnghiemEntity, Long> {
    
}
