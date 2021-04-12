package com.assigment.hospital.entity;

import java.sql.Date;
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
@Table(name = "chitietphong", schema = "hospital")
@NoArgsConstructor
@AllArgsConstructor
public class ChitietphongEntity {
    private long maphong;
    private Long mabn;
    private Date ngaybatdau;
    private Date ngayketthuc;
    private PhongEntity phongByMaphong;

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
    @Column(name = "mabn", nullable = true)
    public Long getMabn() {
        return mabn;
    }

    public void setMabn(Long mabn) {
        this.mabn = mabn;
    }

    @Basic
    @Column(name = "ngaybatdau", nullable = true)
    public Date getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(Date ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    @Basic
    @Column(name = "ngayketthuc", nullable = true)
    public Date getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(Date ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChitietphongEntity that = (ChitietphongEntity) o;
        return maphong == that.maphong && Objects.equals(mabn, that.mabn) && Objects.equals(ngaybatdau, that.ngaybatdau) && Objects.equals(ngayketthuc, that.ngayketthuc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maphong, mabn, ngaybatdau, ngayketthuc);
    }

    @OneToOne
    @JoinColumn(name = "maphong", referencedColumnName = "maphong", nullable = false)
    public PhongEntity getPhongByMaphong() {
        return phongByMaphong;
    }

    public void setPhongByMaphong(PhongEntity phongByMaphong) {
        this.phongByMaphong = phongByMaphong;
    }
}
