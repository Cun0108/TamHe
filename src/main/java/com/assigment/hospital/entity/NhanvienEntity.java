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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nhanvien", schema = "hospital")
@NoArgsConstructor
@AllArgsConstructor
public class NhanvienEntity {
    private long manv;
    private String hoten;
    private Boolean gioitinh;
    private Date ngaysinh;
    private String diachi;
    private String trangthai;
    private Double hesoluong;
    private Double luong;
    private String motathem;
    private KhoaEntity khoaByMakhoa;
    private TaikhoanEntity taikhoansByManv;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manv", nullable = false)
    public long getManv() {
        return manv;
    }

    public void setManv(long manv) {
        this.manv = manv;
    }

    @Basic
    @Column(name = "hoten", nullable = true, length = 50)
    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    @Basic
    @Column(name = "gioitinh", nullable = true)
    public Boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    @Basic
    @Column(name = "ngaysinh", nullable = true)
    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    @Basic
    @Column(name = "diachi", nullable = true, length = 100)
    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Basic
    @Column(name = "trangthai", nullable = true, length = 50)
    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Basic
    @Column(name = "hesoluong", nullable = true, precision = 0)
    public Double getHesoluong() {
        return hesoluong;
    }

    public void setHesoluong(Double hesoluong) {
        this.hesoluong = hesoluong;
    }

    @Basic
    @Column(name = "luong", nullable = true, precision = 0)
    public Double getLuong() {
        return luong;
    }

    public void setLuong(Double luong) {
        this.luong = luong;
    }

    @Basic
    @Column(name = "motathem", nullable = true, length = 255)
    public String getMotathem() {
        return motathem;
    }

    public void setMotathem(String motathem) {
        this.motathem = motathem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhanvienEntity that = (NhanvienEntity) o;
        return manv == that.manv && Objects.equals(hoten, that.hoten) && Objects.equals(gioitinh, that.gioitinh) && Objects.equals(ngaysinh, that.ngaysinh) && Objects.equals(diachi, that.diachi) && Objects.equals(trangthai, that.trangthai) && Objects.equals(hesoluong, that.hesoluong) && Objects.equals(luong, that.luong) && Objects.equals(motathem, that.motathem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manv, hoten, gioitinh, ngaysinh, diachi, trangthai, hesoluong, luong, motathem);
    }

    @ManyToOne
    @JoinColumn(name = "makhoa", referencedColumnName = "makhoa", nullable = false)
    public KhoaEntity getKhoaByMakhoa() {
        return khoaByMakhoa;
    }

    public void setKhoaByMakhoa(KhoaEntity khoaByMakhoa) {
        this.khoaByMakhoa = khoaByMakhoa;
    }

    @OneToOne(mappedBy = "nhanvienByManv")
    public TaikhoanEntity getTaikhoansByManv() {
        return taikhoansByManv;
    }

    public void setTaikhoansByManv(TaikhoanEntity taikhoansByManv) {
        this.taikhoansByManv = taikhoansByManv;
    }

    
}
