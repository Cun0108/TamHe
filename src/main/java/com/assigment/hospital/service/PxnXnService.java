package com.assigment.hospital.service;

import java.util.List;

import com.assigment.hospital.entity.PxnXnEntity;
import com.assigment.hospital.repository.PxnXnRepository;

import org.springframework.stereotype.Service;

@Service
public class PxnXnService {
    
    private final PxnXnRepository repository;

    public PxnXnService(PxnXnRepository repository) {
        this.repository = repository;
    }

    public void savePxnXn(PxnXnEntity pxnXn) {
        repository.saveAndFlush(pxnXn);
    }

    public List<PxnXnEntity> getByMapxn(long mapxn) {
        return repository.findByMapxn(mapxn);
    }

}
