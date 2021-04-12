package com.assigment.hospital.entity;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "khoa", schema = "hospital")
@NoArgsConstructor
@AllArgsConstructor
public class KhoaEntity {
    private long maKhoa;
    private String tenKhoa;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "makhoa", nullable = false)
    public long getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(long maKhoa) {
        this.maKhoa = maKhoa;
    }

    @Basic
    @Column(name = "tenkhoa", nullable = true, length = 100)
    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KhoaEntity that = (KhoaEntity) o;
        return maKhoa == that.maKhoa && Objects.equals(tenKhoa, that.tenKhoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKhoa, tenKhoa);
    }
}
