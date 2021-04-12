package com.assigment.hospital.controller;

import com.assigment.hospital.entity.BenhnhanEntity;
import com.assigment.hospital.entity.DonthuocEntity;
import com.assigment.hospital.repository.BenhnhanRepository;
import com.assigment.hospital.repository.DonthuocRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class DieutrinoitruController {

    private final DonthuocRepository donthuocRepository;
    private final BenhnhanRepository benhnhanRepository;

    public DieutrinoitruController(DonthuocRepository donthuocRepository, BenhnhanRepository benhnhanRepository) {
        this.donthuocRepository = donthuocRepository;
        this.benhnhanRepository = benhnhanRepository;
    }

    @GetMapping("/dieutrinoitru")
    public String dieutrinoitru() {
        return "formdieutrinoitru";
    }

    @PostMapping("/dieutrinoitru")
    public String postrequest(@RequestParam long mabn, Model model) {
        Optional<BenhnhanEntity> optional = benhnhanRepository.findById(mabn);
        if (!optional.isPresent()) {
            return "redirect:404";
        }

        List<DonthuocEntity> list = donthuocRepository.findAllByMabn(mabn);
        model.addAttribute("list_dt", list);
        model.addAttribute("bn", optional.get());
        return "dieutrinoitru";
    }

    @PostMapping("/updatedieutrinoitru")
    public String update(
            @RequestParam long mabn,
            @RequestParam List<Date> thoigian,
            @RequestParam List<String> thuoc,
            @RequestParam List<Integer> soluong,
            @RequestParam List<Integer> tien,
//            @RequestParam List<String> isAdded,
            Model model) {
        Optional<BenhnhanEntity> optional = benhnhanRepository.findById(mabn);
        if (!optional.isPresent()) {
            return "redirect:404";
        }

        for (int i = 0; i < thoigian.size(); i++) {
            DonthuocEntity donthuocEntity = new DonthuocEntity();
            donthuocEntity.setMabn(mabn);
            donthuocEntity.setThoigian(thoigian.get(i));
            donthuocEntity.setThuoc(thuoc.get(i));
            donthuocEntity.setSoluong(soluong.get(i));
            donthuocEntity.setTien(tien.get(i));


            donthuocRepository.saveAndFlush(donthuocEntity);
//            if (isAdded.get(i).equalsIgnoreCase("themmoi")) {
//                donthuocRepository.saveAndFlush(donthuocEntity);
//            }
        }

        List<DonthuocEntity> list = donthuocRepository.findAllByMabn(mabn);
        model.addAttribute("list_dt", list);
        model.addAttribute("bn", optional.get());

        return "dieutrinoitru";
    }

    @PostMapping("/findthuoc")
    public String findDonThuoc(@RequestParam long mabn,
                               @RequestParam String thuoc,
                               Model model) {
        Optional<BenhnhanEntity> optional = benhnhanRepository.findById(mabn);
        List<DonthuocEntity> list = donthuocRepository.findByMabnAndThuocContains(mabn, thuoc);
        model.addAttribute("list_dt", list);
        model.addAttribute("bn", optional.get());
        return "dieutrinoitru";
    }


}
