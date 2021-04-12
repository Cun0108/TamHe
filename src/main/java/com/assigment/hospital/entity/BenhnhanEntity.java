package com.assigment.hospital.entity;

import java.sql.Date;
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
@Table(name = "benhnhan", schema = "hospital")
@NoArgsConstructor
@AllArgsConstructor
public class BenhnhanEntity {
    private long maBn;
    private String hoTen;
    private Date ngaySinh;
    private Boolean gioiTinh;
    private String soDienThoai;
    private String diaChi;
    private Date ngayTiepNhan;
    private String noiDungKham;
    private String maKhoa;
    private Boolean doiTuong;
    private String soTheBaoHiem;
    private Double loaiBaoHiem;
    private Boolean nhapVien;
    private String lyDoNhapVien;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mabn", nullable = false)
    public long getMaBn() {
        return maBn;
    }

    public void setMaBn(long maBn) {
        this.maBn = maBn;
    }

    @Basic
    @Column(name = "hoten", nullable = true, length = 50)
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Basic
    @Column(name = "ngaysinh", nullable = true)
    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Basic
    @Column(name = "gioitinh", nullable = true)
    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Basic
    @Column(name = "sodienthoai", nullable = true, length = 12)
    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Basic
    @Column(name = "diachi", nullable = true, length = 50)
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Basic
    @Column(name = "ngaytiepnhan", nullable = true)
    public Date getNgayTiepNhan() {
        return ngayTiepNhan;
    }

    public void setNgayTiepNhan(Date ngayTiepNhan) {
        this.ngayTiepNhan = ngayTiepNhan;
    }

    @Basic
    @Column(name = "noidungkham", nullable = true, length = 50)
    public String getNoiDungKham() {
        return noiDungKham;
    }

    public void setNoiDungKham(String noiDungKham) {
        this.noiDungKham = noiDungKham;
    }

    @Basic
    @Column(name = "makhoa", nullable = true, length = 50)
    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    @Basic
    @Column(name = "doituong", nullable = true)
    public Boolean getDoiTuong() {
        return doiTuong;
    }

    public void setDoiTuong(Boolean doiTuong) {
        this.doiTuong = doiTuong;
    }

    @Basic
    @Column(name = "sothebaohiem", nullable = true, length = 50)
    public String getSoTheBaoHiem() {
        return soTheBaoHiem;
    }

    public void setSoTheBaoHiem(String soTheBaoHiem) {
        this.soTheBaoHiem = soTheBaoHiem;
    }

    @Basic
    @Column(name = "loaibaohiem", nullable = true, precision = 0)
    public Double getLoaiBaoHiem() {
        return loaiBaoHiem;
    }

    public void setLoaiBaoHiem(Double loaiBaoHiem) {
        this.loaiBaoHiem = loaiBaoHiem;
    }

    @Basic
    @Column(name = "nhapvien", nullable = true)
    public Boolean getNhapVien() {
        return nhapVien;
    }

    public void setNhapVien(Boolean nhapVien) {
        this.nhapVien = nhapVien;
    }

    @Basic
    @Column(name = "lydonhapvien", nullable = true, length = 255)
    public String getLyDoNhapVien() {
        return lyDoNhapVien;
    }

    public void setLyDoNhapVien(String lyDoNhapVien) {
        this.lyDoNhapVien = lyDoNhapVien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BenhnhanEntity that = (BenhnhanEntity) o;
        return maBn == that.maBn && Objects.equals(hoTen, that.hoTen) && Objects.equals(ngaySinh, that.ngaySinh) && Objects.equals(gioiTinh, that.gioiTinh) && Objects.equals(soDienThoai, that.soDienThoai) && Objects.equals(diaChi, that.diaChi) && Objects.equals(ngayTiepNhan, that.ngayTiepNhan) && Objects.equals(noiDungKham, that.noiDungKham) && Objects.equals(maKhoa, that.maKhoa) && Objects.equals(doiTuong, that.doiTuong) && Objects.equals(soTheBaoHiem, that.soTheBaoHiem) && Objects.equals(loaiBaoHiem, that.loaiBaoHiem) && Objects.equals(nhapVien, that.nhapVien) && Objects.equals(lyDoNhapVien, that.lyDoNhapVien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maBn, hoTen, ngaySinh, gioiTinh, soDienThoai, diaChi, ngayTiepNhan, noiDungKham, maKhoa, doiTuong, soTheBaoHiem, loaiBaoHiem, nhapVien, lyDoNhapVien);
    }

    @Override
    public String toString() {
        return "BenhnhanEntity [diaChi=" + diaChi + ", doiTuong=" + doiTuong + ", gioiTinh=" + gioiTinh + ", hoTen="
                + hoTen + ", loaiBaoHiem=" + loaiBaoHiem + ", lyDoNhapVien=" + lyDoNhapVien + ", maBn=" + maBn
                + ", maKhoa=" + maKhoa + ", ngaySinh=" + ngaySinh + ", ngayTiepNhan=" + ngayTiepNhan + ", nhapVien="
                + nhapVien + ", noiDungKham=" + noiDungKham + ", soDienThoai=" + soDienThoai + ", soTheBaoHiem="
                + soTheBaoHiem + "]";
    }

    
}
