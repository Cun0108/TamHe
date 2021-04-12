package com.assigment.hospital.controller;

import java.util.List;

import com.assigment.hospital.entity.BenhnhanEntity;
import com.assigment.hospital.entity.XetnghiemEntity;
import com.assigment.hospital.service.BenhnhanService;
import com.assigment.hospital.service.KetquaxetnghiemService;
import com.assigment.hospital.service.PhieuxetnghiemService;
import com.assigment.hospital.service.XetnghiemService;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PhieuxetnghiemController {

    private final BenhnhanService benhNhanService;
    private final PhieuxetnghiemService service;
    private final XetnghiemService xetNghiemService;
    private final KetquaxetnghiemService kqService;


    public PhieuxetnghiemController(BenhnhanService benhNhanService, 
                                    PhieuxetnghiemService service, 
                                    XetnghiemService xetNghiemService,
                                    KetquaxetnghiemService kqService) {
        this.benhNhanService = benhNhanService;
        this.service = service;
        this.xetNghiemService = xetNghiemService;
        this.kqService = kqService;
    }
    
    @GetMapping("/phieuxetnghiem")
    public String showFormNhapMaBN() {
        return "formxetnghiem";
    }

    @PostMapping("/phieuxetnghiem")
    public String showFormXetNghiem(@RequestParam("mabn") long mabn, Model model) {
        BenhnhanEntity benhNhan = benhNhanService.getById(mabn);
        List<XetnghiemEntity> listXetNghiem = xetNghiemService.getAll();

        if (benhNhan == null) {
            return "redirect:404";
        }
        model.addAttribute("benhNhan", benhNhan);
        if (benhNhan.getGioiTinh()) {
            model.addAttribute("gioitinh", "Nam");
        } else {
            model.addAttribute("gioitinh", "Nữ");
        }
        model.addAttribute("xetnghiem", listXetNghiem);
        return "qlXetNghiem1";
    }

    @PostMapping("/xetnghiem")
    public String xetnghiem(@RequestParam("mabn") long mabn,
                            @RequestParam("maxn") List<Long> maxn, 
                            @RequestParam("ketqua") List<Integer> listketqua,
                            @RequestParam("ghichu") List<String> listghichu,
                            Authentication authResult,
                            Model model) {
        service.savePhieuxetnghiem(mabn, maxn, listketqua, listghichu, authResult);
        model = kqService.showKetQua(mabn, model);
        if (model.getAttribute("chuaxetnghiemkhambenh") != "" && model.getAttribute("chuaxetnghiemkhambenh") != null) {
            return "chuaxetnghiemkhambenh";
        }
        return "ketquaxetnghiem";
    }

}
