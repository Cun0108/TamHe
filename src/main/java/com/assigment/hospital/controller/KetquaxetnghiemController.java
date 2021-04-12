package com.assigment.hospital.controller;

import com.assigment.hospital.service.KetquaxetnghiemService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KetquaxetnghiemController {

    private final KetquaxetnghiemService service;

    public KetquaxetnghiemController(KetquaxetnghiemService service) {
        this.service = service;
    }
    
    @GetMapping("/ketquaxetnghiem")
    public String showFormNhapMabn() {
        return "formkqxetnghiem";
    }

    @PostMapping("/ketquaxetnghiem")
    public String showKetQua(@RequestParam("mabn") long mabn, Model model) {
        model = service.showKetQua(mabn, model);
        if (model.getAttribute("chuaxetnghiemkhambenh") != "" && model.getAttribute("chuaxetnghiemkhambenh") != null) {
            return "chuaxetnghiemkhambenh";
        }
        return "ketquaxetnghiem";
    }

}
