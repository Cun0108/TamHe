package com.assigment.hospital.controller;

import java.sql.Date;
import java.util.List;

import com.assigment.hospital.service.BenhnhanService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HosobenhnhanController {
    
    private final BenhnhanService benhnhanService;

    public HosobenhnhanController(BenhnhanService benhnhanService) {
        this.benhnhanService = benhnhanService;
    }

    @GetMapping("/hosobenhnhan")
    public String showDanhSach(Model model) {
        benhnhanService.xoaBenhNhanNull();
        model.addAttribute("listBenhnhan", benhnhanService.getAll());
        return "quanlyhosobenhan";
    }

    @PostMapping("/capnhathoso")
    public String capNhatHoSo(@RequestParam("maBn") List<Long> mabn,
                              @RequestParam("hoTen") List<String> hoTen,
                              @RequestParam("ngaySinh") List<Date> ngaySinh,
                              @RequestParam("diaChi") List<String> diaChi,
                              @RequestParam("gioiTinh") List<String> gioiTinh,
                              @RequestParam("noiDungKham") List<String> noiDungKham,
                              @RequestParam("ngayTiepNhan") List<Date> ngayTiepNhan,
                              @RequestParam(name = "isDelete", defaultValue = "") List<Long> isDelete,
                              Model model) {
        benhnhanService.capNhatHoSoBenhNhan(mabn, hoTen, ngaySinh, diaChi, gioiTinh, noiDungKham, ngayTiepNhan, isDelete);
        benhnhanService.xoaBenhNhanNull();
        model.addAttribute("listBenhnhan", benhnhanService.getAll());
        return "quanlyhosobenhan";
    }

    @PostMapping("/timhoso")
    public String timHoSo(@RequestParam("hoTen") String hoTen, Model model) {
        model.addAttribute("listBenhnhan", benhnhanService.getByHoTen(hoTen));
        return "quanlyhosobenhan";
    }

}
