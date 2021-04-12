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
@Table(name = "xetnghiem", schema = "hospital")
@NoArgsConstructor
@AllArgsConstructor
public class XetnghiemEntity {
    private long maxn;
    private String tenxn;
    private String donvi;
    private Double gia;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maxn", nullable = false)
    public long getMaxn() {
        return maxn;
    }

    public void setMaxn(long maxn) {
        this.maxn = maxn;
    }

    @Basic
    @Column(name = "tenxn", nullable = true, length = 50)
    public String getTenxn() {
        return tenxn;
    }

    public void setTenxn(String tenxn) {
        this.tenxn = tenxn;
    }

    @Basic
    @Column(name = "donvi", nullable = true, length = 20)
    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    @Basic
    @Column(name = "gia", nullable = true, precision = 0)
    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XetnghiemEntity that = (XetnghiemEntity) o;
        return maxn == that.maxn && Objects.equals(tenxn, that.tenxn) && Objects.equals(donvi, that.donvi) && Objects.equals(gia, that.gia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxn, tenxn, donvi, gia);
    }
}
