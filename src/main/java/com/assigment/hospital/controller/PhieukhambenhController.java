package com.assigment.hospital.controller;

import java.sql.Date;

import com.assigment.hospital.entity.BenhnhanEntity;
import com.assigment.hospital.entity.NhanvienEntity;
import com.assigment.hospital.entity.PhieukhambenhEntity;
import com.assigment.hospital.entity.TaikhoanEntity;
import com.assigment.hospital.repository.TaiKhoanRepository;
import com.assigment.hospital.security.UserPrincipal;
import com.assigment.hospital.service.BenhnhanService;
import com.assigment.hospital.service.NhanvienService;
import com.assigment.hospital.service.PhieukhambenhService;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PhieukhambenhController {
    
    private final PhieukhambenhService service;
    private final NhanvienService nhanvienService;
    private final BenhnhanService benhnhanService;
    private final TaiKhoanRepository taiKhoanRepository;

    public PhieukhambenhController(PhieukhambenhService service,
                                   BenhnhanService benhNhanService,
                                   NhanvienService nhanvienService, TaiKhoanRepository taiKhoanRepository) {
        this.service = service;
        this.benhnhanService = benhNhanService;
        this.nhanvienService = nhanvienService;
        this.taiKhoanRepository = taiKhoanRepository;
    }

    @GetMapping("/phieukhambenh")
    public String redirectToFormNhapMaBN() {
        return "formkhambenh";
    }

    @PostMapping("/phieukhambenh")
    public String showPhieukhambenh(@RequestParam("mabn") long mabn, Model model) {
        BenhnhanEntity benhNhan = benhnhanService.getById(mabn);
        if (benhNhan == null) {
            return "404";
        }
        model.addAttribute("benhNhan", benhNhan);
        if (benhNhan.getGioiTinh()) {
            model.addAttribute("gioitinh", "Nam");
        } else {
            model.addAttribute("gioitinh", "Nữ");
        }
        return "quanlykhambenh";
    }

    @PostMapping("/khambenh")
    public String khamBenh(@RequestParam("mabn") long mabn, PhieukhambenhEntity phieukhambenh, Authentication authResult) {
        BenhnhanEntity benhNhan = benhnhanService.getById(mabn);

        UserPrincipal userPrincipal = (UserPrincipal) authResult.getPrincipal();
        TaikhoanEntity taikhoan = taiKhoanRepository.findTaikhoanEntityByUsername(userPrincipal.getUsername()).get();

        // TODO: Need to change with Current User
        NhanvienEntity nhanVien = taikhoan.getNhanvienByManv();
        // Set name for bac si chi dinh
        phieukhambenh.setManv(nhanVien.getManv());

        phieukhambenh.setBenhnhanByMabn(benhNhan);
        long millis=System.currentTimeMillis();
        Date ngaychidinh = new Date(millis);
        phieukhambenh.setNgaychidinh(ngaychidinh);
        service.luuPhieuKhamBenh(phieukhambenh);
        return "formkhambenh";
    }

}
