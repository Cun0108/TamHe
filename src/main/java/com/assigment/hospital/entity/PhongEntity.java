package com.assigment.hospital.entity;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "phong", schema = "hospital")
@NoArgsConstructor
@AllArgsConstructor
public class PhongEntity {
    private long maphong;
    private String tenphong;
    private KhoaEntity khoaByMakhoa;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maphong", nullable = false)
    public long getMaphong() {
        return maphong;
    }

    public void setMaphong(long maphong) {
        this.maphong = maphong;
    }

    @Basic
    @Column(name = "tenphong", nullable = true, length = 50)
    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhongEntity that = (PhongEntity) o;
        return maphong == that.maphong && Objects.equals(tenphong, that.tenphong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maphong, tenphong);
    }

    @ManyToOne
    @JoinColumn(name = "makhoa", referencedColumnName = "makhoa", nullable = false)
    public KhoaEntity getKhoaByMakhoa() {
        return khoaByMakhoa;
    }

    public void setKhoaByMakhoa(KhoaEntity khoaByMakhoa) {
        this.khoaByMakhoa = khoaByMakhoa;
    }
}
