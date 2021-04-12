package com.assigment.hospital.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "donthuoc", schema = "hospital", catalog = "")
public class DonthuocEntity {
    private long id;
    private Date thoigian;
    private Long mabn;
    private String thuoc;
    private Integer soluong;
    private Integer tien;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "thoigian")
    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    @Basic
    @Column(name = "mabn")
    public Long getMabn() {
        return mabn;
    }

    public void setMabn(Long mabn) {
        this.mabn = mabn;
    }

    @Basic
    @Column(name = "thuoc")
    public String getThuoc() {
        return thuoc;
    }

    public void setThuoc(String thuoc) {
        this.thuoc = thuoc;
    }

    @Basic
    @Column(name = "soluong")
    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    @Basic
    @Column(name = "tien")
    public Integer getTien() {
        return tien;
    }

    public void setTien(Integer tien) {
        this.tien = tien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonthuocEntity that = (DonthuocEntity) o;
        return id == that.id && Objects.equals(thoigian, that.thoigian) && Objects.equals(mabn, that.mabn) && Objects.equals(thuoc, that.thuoc) && Objects.equals(soluong, that.soluong) && Objects.equals(tien, that.tien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, thoigian, mabn, thuoc, soluong, tien);
    }
}
