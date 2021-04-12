package com.assigment.hospital.service;

import java.util.List;
import java.util.Optional;

import com.assigment.hospital.entity.XetnghiemEntity;
import com.assigment.hospital.repository.XetnghiemRepository;

import org.springframework.stereotype.Service;

@Service
public class XetnghiemService {

    private final XetnghiemRepository repository;

    public XetnghiemService(XetnghiemRepository repository) {
        this.repository = repository;
    }
    
    public List<XetnghiemEntity> getAll() {
        return repository.findAll();
    }

    public XetnghiemEntity getById(long maxn) {
        Optional<XetnghiemEntity> optional = repository.findById(maxn);
        if (optional.isPresent()) {
            XetnghiemEntity xetnghiem = optional.get();
            return xetnghiem;
        }
        return null;
    }

}
