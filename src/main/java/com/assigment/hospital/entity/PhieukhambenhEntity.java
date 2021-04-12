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
@Table(name = "phieukhambenh", schema = "hospital")
@NoArgsConstructor
@AllArgsConstructor
public class PhieukhambenhEntity {
    private Long id;
    private String chuandoan;
    private String ketluan;
    private String donthuoc;
    private Date ngaytaikham;
    private Boolean cantaikham;
    private Date ngaychidinh;
    private long mabn;
    private long manv;
    private BenhnhanEntity benhnhanByMabn;
    private NhanvienEntity nhanvienByManv;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "chuandoan", nullable = true, length = 255)
    public String getChuandoan() {
        return chuandoan;
    }

    public void setChuandoan(String chuandoan) {
        this.chuandoan = chuandoan;
    }

    @Basic
    @Column(name = "ketluan", nullable = true, length = 255)
    public String getKetluan() {
        return ketluan;
    }

    public void setKetluan(String ketluan) {
        this.ketluan = ketluan;
    }

    @Basic
    @Column(name = "donthuoc", nullable = true, length = 255)
    public String getDonthuoc() {
        return donthuoc;
    }

    public void setDonthuoc(String donthuoc) {
        this.donthuoc = donthuoc;
    }

    @Basic
    @Column(name = "ngaytaikham", nullable = true)
    public Date getNgaytaikham() {
        return ngaytaikham;
    }

    public void setNgaytaikham(Date ngaytaikham) {
        this.ngaytaikham = ngaytaikham;
    }

    @Basic
    @Column(name = "cantaikham", nullable = true)
    public Boolean getCantaikham() {
        return cantaikham;
    }

    public void setCantaikham(Boolean cantaikham) {
        this.cantaikham = cantaikham;
    }

    @Basic
    @Column(name = "ngaychidinh", nullable = true)
    public Date getNgaychidinh() {
        return ngaychidinh;
    }

    public void setNgaychidinh(Date ngaychidinh) {
        this.ngaychidinh = ngaychidinh;
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
    @Column(name = "manv", nullable = false)
    public long getManv() {
        return manv;
    }

    public void setManv(long manv) {
        this.manv = manv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhieukhambenhEntity that = (PhieukhambenhEntity) o;
        return mabn == that.mabn && manv == that.manv && Objects.equals(id, that.id) && Objects.equals(chuandoan, that.chuandoan) && Objects.equals(ketluan, that.ketluan) && Objects.equals(donthuoc, that.donthuoc) && Objects.equals(ngaytaikham, that.ngaytaikham) && Objects.equals(cantaikham, that.cantaikham)  && Objects.equals(ngaychidinh, that.ngaychidinh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chuandoan, ketluan, donthuoc, ngaytaikham, cantaikham, ngaychidinh, mabn, manv);
    }

    @ManyToOne
    @JoinColumn(name = "mabn", referencedColumnName = "mabn", nullable = false, insertable = false, updatable = false)
    public BenhnhanEntity getBenhnhanByMabn() {
        return benhnhanByMabn;
    }

    public void setBenhnhanByMabn(BenhnhanEntity benhnhanByMabn) {
        this.benhnhanByMabn = benhnhanByMabn;
    }

    @ManyToOne
    @JoinColumn(name = "manv", referencedColumnName = "manv", nullable = false, insertable = false, updatable = false)
    public NhanvienEntity getNhanvienByManv() {
        return nhanvienByManv;
    }

    public void setNhanvienByManv(NhanvienEntity nhanvienByManv) {
        this.nhanvienByManv = nhanvienByManv;
    }

    @Override
    public String toString() {
        return "PhieukhambenhEntity [benhnhanByMabn=" + benhnhanByMabn + ", cantaikham=" + cantaikham + ", chuandoan="
                + chuandoan + ", donthuoc=" + donthuoc + ", id=" + id + ", ketluan=" + ketluan + ", mabn=" + mabn
                + ", manv=" + manv + ", ngaychidinh=" + ngaychidinh + ", ngaytaikham=" + ngaytaikham
                + ", nhanvienByManv=" + nhanvienByManv + "]";
    }
    
}
