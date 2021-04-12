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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "phieuxetnghiem", schema = "hospital")
@NoArgsConstructor
@AllArgsConstructor
public class PhieuxetnghiemEntity {
    private long mapxn;
    private long manv;
    private long mabn;
    private Date ngaythuchien;
    private NhanvienEntity nhanvienByManv;
    private BenhnhanEntity benhnhanByMabn;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mapxn", nullable = false)
    public long getMapxn() {
        return mapxn;
    }

    public void setMapxn(long mapxn) {
        this.mapxn = mapxn;
    }

    @Basic
    @Column(name = "manv", nullable = false)
    public long getManv() {
        return manv;
    }

    public void setManv(long manv) {
        this.manv = manv;
    }

    @Basic
    @Column(name = "mabn", nullable = false)
    public long getMabn() {
        return mabn;
    }

    public void setMabn(long mabn) {
        this.mabn = mabn;
    }

    @Basic
    @Column(name = "ngaythuchien", nullable = true)
    public Date getNgaythuchien() {
        return ngaythuchien;
    }
    
    public void setNgaythuchien(Date ngaythuchien) {
        this.ngaythuchien = ngaythuchien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhieuxetnghiemEntity that = (PhieuxetnghiemEntity) o;
        return mapxn == that.mapxn && Objects.equals(ngaythuchien, that.ngaythuchien) && manv == that.manv && mabn == that.mabn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapxn, ngaythuchien, manv, mabn);
    }

    @ManyToOne
    @JoinColumn(name = "manv", referencedColumnName = "manv", nullable = false, insertable = false, updatable = false)
    public NhanvienEntity getNhanvienByManv() {
        return nhanvienByManv;
    }

    public void setNhanvienByManv(NhanvienEntity nhanvienByManv) {
        this.nhanvienByManv = nhanvienByManv;
    }

    @ManyToOne
    @JoinColumn(name = "mabn", referencedColumnName = "mabn", nullable = false, insertable = false, updatable = false)
    public BenhnhanEntity getBenhnhanByMabn() {
        return benhnhanByMabn;
    }

    public void setBenhnhanByMabn(BenhnhanEntity benhnhanByMabn) {
        this.benhnhanByMabn = benhnhanByMabn;
    }

    @Override
    public String toString() {
        return "PhieuxetnghiemEntity [benhnhanByMabn=" + benhnhanByMabn + ", mabn=" + mabn + ", manv=" + manv
                + ", mapxn=" + mapxn + ", ngaythuchien=" + ngaythuchien + ", nhanvienByManv=" + nhanvienByManv + "]";
    }

    
}
