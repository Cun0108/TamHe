package com.assigment.hospital.service;

import com.assigment.hospital.entity.BenhnhanEntity;
import com.assigment.hospital.repository.BenhnhanRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DSBNService {
    private final BenhnhanRepository benhnhanRepository;

    public DSBNService(BenhnhanRepository benhnhanRepository) {
        this.benhnhanRepository = benhnhanRepository;
    }

    public List<BenhnhanEntity> dsbnnt() { //2
        return benhnhanRepository
                .findAll()
                .stream()
                .filter(BenhnhanEntity::getNhapVien)
                .collect(Collectors.toList());
    }

    public List<BenhnhanEntity> dsbnnt_knt() {
        return benhnhanRepository
                .findAll()
                .stream()
                .filter(benhnhan -> !benhnhan.getNhapVien())
                .collect(Collectors.toList());
    }

    public Set<String> list_khoa() {
        Set<String> makhoa = new HashSet<>();
        Set<String> khoa = new HashSet<>();

        benhnhanRepository
                .findAll()
                .stream()
                .filter(benhnhan -> benhnhan.getMaKhoa().contains("-"))
                .collect(Collectors.toList())
                .forEach(bennhan -> makhoa.add(bennhan.getMaKhoa()));

        makhoa
                .forEach(s -> {
                    int pos = 0;

                    for (int index = 0; index < s.length(); index++) {
                        if (s.charAt(index)=='-') {
                            pos=index;
                        }
                    }
                    khoa.add(s.substring(0, pos));
                });

        return khoa;
    }

    public Set<String> list_phong() {
        Set<String> makhoa = new HashSet<>();
        Set<String> khoa = new HashSet<>();

        benhnhanRepository
                .findAll()
                .stream()
                .filter(benhnhan -> benhnhan.getMaKhoa().contains("-"))
                .collect(Collectors.toList())
                .forEach(bennhan -> makhoa.add(bennhan.getMaKhoa()));

        makhoa
                .forEach(s -> {
                    int pos = 0;

                    for (int index = 0; index < s.length(); index++) {
                        if (s.charAt(index)=='-') {
                            pos=index;
                        }
                    }
                    khoa.add(s.substring(pos+1, s.length()));
                });
        return khoa;
    }

    public Set<Date> list_ngaynhapvien() { //1
        Set<Date> makhoa = new HashSet<>();
        Set<Date> ngay = new HashSet<>();

        benhnhanRepository
                .findAll()
                .stream()
                .collect(Collectors.toList())
                .forEach(bennhan -> ngay.add(bennhan.getNgayTiepNhan()));

        return ngay;
    }

}
