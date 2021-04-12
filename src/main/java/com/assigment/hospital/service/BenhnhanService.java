package com.assigment.hospital.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.assigment.hospital.entity.BenhnhanEntity;
import com.assigment.hospital.repository.BenhnhanRepository;

import org.springframework.stereotype.Service;

@Service
public class BenhnhanService {
    
    private final BenhnhanRepository repository;

    public BenhnhanService(BenhnhanRepository repository) {
        this.repository = repository;
    }
    
    public BenhnhanEntity tiepNhanBenhNhan() {
        BenhnhanEntity benhNhan = new BenhnhanEntity();
        benhNhan = repository.saveAndFlush(benhNhan);
        return benhNhan;
    }

    public void xoaBenhNhanNull() {
        List<BenhnhanEntity> list = getAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getHoTen() == null) {
                repository.deleteById(list.get(i).getMaBn());
            }
        }
    }

    public void luuBenhNhan(BenhnhanEntity benhNhan) {
        repository.saveAndFlush(benhNhan);
        xoaBenhNhanNull();
    }

    public BenhnhanEntity getById(long maBn) {
        Optional<BenhnhanEntity> optional = repository.findById(maBn);
        if (optional.isPresent()) {
            BenhnhanEntity benhNhan = optional.get();
            return benhNhan;
        }
        return null;
    }

    public List<BenhnhanEntity> getAll() {
        return repository.findAll();
    }

    public void capNhatHoSoBenhNhan(List<Long> mabn,
                                    List<String> hoTen,
                                    List<Date> ngaySinh,
                                    List<String> diaChi,
                                    List<String> gioiTinh,
                                    List<String> noiDungKham,
                                    List<Date> ngayTiepNhan,
                                    List<Long> isDelete) {
        for (int i = 0; i < mabn.size(); i++) {
            boolean gioitinh = true;
            if (gioiTinh.get(i).equalsIgnoreCase("Nam")) {
                gioitinh = true;
            } else if (gioiTinh.get(i).equalsIgnoreCase("Nữ")) {
                gioitinh = false;
            }
            BenhnhanEntity benhNhan = getById(mabn.get(i));
            for (int j = 0; j < isDelete.size(); j++) {
                if (mabn.get(i) == isDelete.get(j)) {
                    repository.deleteById(isDelete.get(j));
                } else {
                    benhNhan.setHoTen(hoTen.get(i));
                    benhNhan.setNgaySinh(ngaySinh.get(i));
                    benhNhan.setDiaChi(diaChi.get(i));
                    benhNhan.setGioiTinh(gioitinh);
                    benhNhan.setNoiDungKham(noiDungKham.get(i));
                    benhNhan.setNgayTiepNhan(ngayTiepNhan.get(i));
                    repository.saveAndFlush(benhNhan);
                }
            }
        }
    }

    public List<BenhnhanEntity> getByHoTen(String hoTen) {
        return repository.findByHoTenContains(hoTen);
    }
}