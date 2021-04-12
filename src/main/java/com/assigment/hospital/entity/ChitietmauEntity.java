package com.assigment.hospital.entity;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chitietmau", schema = "hospital")
@NoArgsConstructor
@AllArgsConstructor
public class ChitietmauEntity {
    private int maChiTietMau;
    private Integer giaDonVi;
    private MauEntity mausByMaChiTietMau;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maChiTietMau", nullable = false)
    public int getMaChiTietMau() {
        return maChiTietMau;
    }

    public void setMaChiTietMau(int maChiTietMau) {
        this.maChiTietMau = maChiTietMau;
    }

    @Basic
    @Column(name = "giaDonVi", nullable = true)
    public Integer getGiaDonVi() {
        return giaDonVi;
    }

    public void setGiaDonVi(Integer giaDonVi) {
        this.giaDonVi = giaDonVi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChitietmauEntity that = (ChitietmauEntity) o;
        return maChiTietMau == that.maChiTietMau && Objects.equals(giaDonVi, that.giaDonVi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maChiTietMau, giaDonVi);
    }

    @OneToOne(mappedBy = "chitietmauByChitietmau")
    public MauEntity getMausByMaChiTietMau() {
        return mausByMaChiTietMau;
    }

    public void setMausByMaChiTietMau(MauEntity mausByMaChiTietMau) {
        this.mausByMaChiTietMau = mausByMaChiTietMau;
    }
}
