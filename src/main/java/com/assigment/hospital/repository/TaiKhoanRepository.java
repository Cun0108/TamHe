package com.assigment.hospital.repository;

import com.assigment.hospital.entity.TaikhoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaikhoanEntity, Long> {
    Optional<TaikhoanEntity> findTaikhoanEntityByUsername(String username);
}
