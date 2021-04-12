package com.assigment.hospital.repository;

import java.sql.Date;
import java.util.List;

import com.assigment.hospital.entity.BenhnhanEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenhnhanRepository extends JpaRepository<BenhnhanEntity, Long> {
    List<BenhnhanEntity> findByHoTenContains(String hoTen);
    List<BenhnhanEntity> findByMaKhoaContainsAndNgayTiepNhanAndNhapVienAndHoTenContains(String maKhoa, Date ngayTiepNhan, Boolean nhapVien, String hoTen);
}
