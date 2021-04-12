package com.assigment.hospital.service;

import com.assigment.hospital.repository.DonthuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonThuocService {
    private final DonthuocRepository donthuocRepository;

    public DonThuocService(DonthuocRepository donthuocRepository) {
        this.donthuocRepository = donthuocRepository;
    }


}
