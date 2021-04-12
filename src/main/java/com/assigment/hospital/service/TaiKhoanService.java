package com.assigment.hospital.service;

import com.assigment.hospital.dto.TaiKhoanDTO;
import com.assigment.hospital.entity.KhoaEntity;
import com.assigment.hospital.entity.NhanvienEntity;
import com.assigment.hospital.entity.TaikhoanEntity;
import com.assigment.hospital.repository.KHOARepository;
import com.assigment.hospital.repository.NhanvienRepository;
import com.assigment.hospital.repository.TaiKhoanRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaiKhoanService {

    private final KHOARepository khoaRepository;
    private final NhanvienRepository nhanvienRepository;

    private final PasswordEncoder passwordEncoder;
    private final TaiKhoanRepository taiKhoanRepository;

    public TaiKhoanService(KHOARepository khoaRepository, NhanvienRepository nhanvienRepository, PasswordEncoder passwordEncoder, TaiKhoanRepository taiKhoanRepository) {
        this.khoaRepository = khoaRepository;
        this.nhanvienRepository = nhanvienRepository;
        this.passwordEncoder = passwordEncoder;
        this.taiKhoanRepository = taiKhoanRepository;
    }


    public String danky(TaiKhoanDTO taiKhoanDTO) {

        if (taiKhoanRepository.findTaikhoanEntityByUsername(taiKhoanDTO.getUsername()).isPresent()) {
            return "redirect:404";
        }

        KhoaEntity khoa = new KhoaEntity();
        Optional<KhoaEntity> optional = khoaRepository.findKhoaEntitiesByTenKhoa(taiKhoanDTO.getKhoa());
        if (optional.isPresent()) {
            khoa = optional.get();
        } else {
            khoa.setTenKhoa(taiKhoanDTO.getKhoa());
            khoa = khoaRepository.saveAndFlush(khoa);
        }



        NhanvienEntity nhanvien = new NhanvienEntity();
        nhanvien.setHoten(taiKhoanDTO.getTen());
        nhanvien.setKhoaByMakhoa(khoa);
        nhanvien = nhanvienRepository.saveAndFlush(nhanvien);

        TaikhoanEntity taikhoanEntity = new TaikhoanEntity();
        taikhoanEntity.setUsername(taiKhoanDTO.getUsername());
        taikhoanEntity.setNhanvienByManv(nhanvien);
        taikhoanEntity.setRole(taiKhoanDTO.getRole());
        taikhoanEntity.setPassword(passwordEncoder.encode(taiKhoanDTO.getPassword()));
        taikhoanEntity.setManv(nhanvien.getManv());
        taikhoanEntity = taiKhoanRepository.saveAndFlush(taikhoanEntity);

        return "redirect:index";
    }
}
