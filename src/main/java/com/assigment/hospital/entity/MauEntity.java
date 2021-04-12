package com.assigment.hospital.entity;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mau", schema = "hospital")
@NoArgsConstructor
@AllArgsConstructor
public class MauEntity {
    private String maMau;
    private String nhomMau;
    private Integer soLuong;
    private int chitietmau;
    private ChitietmauEntity chitietmauByChitietmau;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maMau", nullable = false, length = 50)
    public String getMaMau() {
        return maMau;
    }

    public void setMaMau(String maMau) {
        this.maMau = maMau;
    }

    @Basic
    @Column(name = "nhomMau", nullable = true, length = 10)
    public String getNhomMau() {
        return nhomMau;
    }

    public void setNhomMau(String nhomMau) {
        this.nhomMau = nhomMau;
    }

    @Basic
    @Column(name = "soLuong", nullable = true)
    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    @Basic
    @Column(name = "chitietmau", nullable = false)
    public int getChitietmau() {
        return chitietmau;
    }

    public void setChitietmau(int chitietmau) {
        this.chitietmau = chitietmau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MauEntity mauEntity = (MauEntity) o;
        return chitietmau == mauEntity.chitietmau && Objects.equals(maMau, mauEntity.maMau) && Objects.equals(nhomMau, mauEntity.nhomMau) && Objects.equals(soLuong, mauEntity.soLuong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maMau, nhomMau, soLuong, chitietmau);
    }

    @OneToOne
    @JoinColumn(name = "chitietmau", referencedColumnName = "maChiTietMau", nullable = false, insertable = false, updatable = false)
    public ChitietmauEntity getChitietmauByChitietmau() {
        return chitietmauByChitietmau;
    }

    public void setChitietmauByChitietmau(ChitietmauEntity chitietmauByChitietmau) {
        this.chitietmauByChitietmau = chitietmauByChitietmau;
    }
}
