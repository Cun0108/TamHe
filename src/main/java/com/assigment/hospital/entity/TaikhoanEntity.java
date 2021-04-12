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
@Table(name = "taikhoan", schema = "hospital")
@NoArgsConstructor
@AllArgsConstructor
public class TaikhoanEntity {
    private Long id;
    private String username;
    private String password;
    private long manv;
    private String role;
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
    @Column(name = "username", nullable = true, length = 30)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "role", nullable = true, length = 30)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaikhoanEntity that = (TaikhoanEntity) o;
        return manv == that.manv && Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, manv, role);
    }

    @OneToOne
    @JoinColumn(name = "manv", referencedColumnName = "manv", nullable = false, insertable = false, updatable = false)
    public NhanvienEntity getNhanvienByManv() {
        return nhanvienByManv;
    }

    public void setNhanvienByManv(NhanvienEntity nhanvienByManv) {
        this.nhanvienByManv = nhanvienByManv;
    }
}
