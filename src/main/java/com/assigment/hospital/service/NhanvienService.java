package com.assigment.hospital.service;

import java.util.Optional;

import com.assigment.hospital.entity.NhanvienEntity;
import com.assigment.hospital.repository.NhanvienRepository;

import org.springframework.stereotype.Service;

@Service
public class NhanvienService {

    private final NhanvienRepository repository;

    public NhanvienService(NhanvienRepository repository) {
        this.repository = repository;
    }
    
    public NhanvienEntity getById(long manv) {
        Optional<NhanvienEntity> optional = repository.findById(manv);

        if (optional.isPresent()) {
            NhanvienEntity nhanVien = optional.get();
            return nhanVien;
        }
        return null;
    }

}
