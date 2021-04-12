package com.assigment.hospital.controller;

import com.assigment.hospital.entity.BenhnhanEntity;
import com.assigment.hospital.repository.BenhnhanRepository;
import com.assigment.hospital.service.DSBNService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class DanhsachbenhnhannoitruController {

    private final DSBNService dsbnService;

    private final BenhnhanRepository benhnhanRepository;

    public DanhsachbenhnhannoitruController(DSBNService dsbnService, BenhnhanRepository benhnhanRepository) {
        this.dsbnService = dsbnService;
        this.benhnhanRepository = benhnhanRepository;
    }

    @GetMapping("/danhsachbenhnhannoitru")
    public String danhsachbenhnhannoitru(Model model) {

        model.addAttribute("listbn", dsbnService.dsbnnt());
        model.addAttribute("list_khoa", dsbnService.list_khoa());
        model.addAttribute("list_phong", dsbnService.list_phong());
        model.addAttribute("list_ngaynhapvien", dsbnService.list_ngaynhapvien());
        model.addAttribute("themlai", false);
        return "danhsachbenhnhannoitru";
    }

    @PostMapping("/timkiembenhnhannoitru")
    public String danhsachbenhnhannoitrufilter(
            @RequestParam String themlai,
            @RequestParam String khoa,
            @RequestParam String phong,
            @RequestParam Date ngay,
            @RequestParam String hoTen,
            Model model) {
        model.addAttribute("list_khoa", dsbnService.list_khoa());
        model.addAttribute("list_phong", dsbnService.list_phong());
        model.addAttribute("list_ngaynhapvien", dsbnService.list_ngaynhapvien());
        model.addAttribute("themlai", themlai.equals(true) ? true : false);

        if (themlai.equals(true)) {
            model.addAttribute("listbn", benhnhanRepository.findByMaKhoaContainsAndNgayTiepNhanAndNhapVienAndHoTenContains(khoa+"-"+phong,ngay,false,hoTen));

        } else {
            model.addAttribute("listbn", benhnhanRepository.findByMaKhoaContainsAndNgayTiepNhanAndNhapVienAndHoTenContains(khoa+"-"+phong,ngay,true,hoTen));
        }
        return "danhsachbenhnhannoitru";
    }

    @GetMapping("/themlai")
    public String themlai(@RequestParam String themlai, Model model) {

        model.addAttribute("list_khoa", dsbnService.list_khoa());
        model.addAttribute("list_phong", dsbnService.list_phong());
        model.addAttribute("list_ngaynhapvien", dsbnService.list_ngaynhapvien());
        model.addAttribute("listbn", dsbnService.dsbnnt_knt());
        model.addAttribute("themlai", true);
        return "danhsachbenhnhannoitru";
    }

    @PostMapping("/xuylycapnhathoacxoa")
    public String xoabn(
            @RequestParam("maBn") List<Long> mabn,
            @RequestParam("hoTen") List<String> hoTen,
            @RequestParam("maKhoa") List<String> maKhoa,
            @RequestParam("ngayTiepNhan") List<Date> ngayTiepNhan,
            @RequestParam(name = "isDelete", defaultValue = "") List<Long> isDelete,
            @RequestParam(name = "themlai") String themlai,
            Model model) {

        model.addAttribute("list_khoa", dsbnService.list_khoa());
        model.addAttribute("list_phong", dsbnService.list_phong());
        model.addAttribute("list_ngaynhapvien", dsbnService.list_ngaynhapvien());
        model.addAttribute("listbn", themlai.equals(true) ? dsbnService.dsbnnt_knt() : dsbnService.dsbnnt());
        model.addAttribute("themlai", themlai.equals(true) ? true : false);

        if (themlai.equals("true")) {
            //them lai
            isDelete
                .stream()
                .forEach(x -> {
                    if (x != null) {
                        BenhnhanEntity a = benhnhanRepository.findById(x).get();
                        a.setNhapVien(true);
                        benhnhanRepository.saveAndFlush(a);
                    }
                });

        }

        if (themlai.equals("false")) {
            //xoa khoi danh sach noi tru
            isDelete
                .stream()
                .forEach(x -> {
                    if (x != null) {
                        BenhnhanEntity a = benhnhanRepository.findById(x).get();
                        a.setNhapVien(false);
                        benhnhanRepository.saveAndFlush(a);
                    }
                });
        }

        return "redirect:danhsachbenhnhannoitru";
    }

}

