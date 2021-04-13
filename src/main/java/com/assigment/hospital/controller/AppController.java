package com.assigment.hospital.controller;

import com.assigment.hospital.dto.TaiKhoanDTO;
import com.assigment.hospital.entity.TaikhoanEntity;
import com.assigment.hospital.repository.TaiKhoanRepository;
import com.assigment.hospital.security.UserPrincipal;
import com.assigment.hospital.service.TaiKhoanService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    private final TaiKhoanRepository taiKhoanRepository;

    private final TaiKhoanService taiKhoanService;

    public AppController(TaiKhoanRepository taiKhoanRepository, TaiKhoanService taiKhoanService) {
        this.taiKhoanRepository = taiKhoanRepository;
        this.taiKhoanService = taiKhoanService;
    }

    @GetMapping("/")
    public String rootURL(Authentication authResult) {
        return common(authResult);
    }

    @GetMapping("/index")
    public String index(Authentication authResult) {
        return common(authResult);
    }

    @GetMapping("/login")
    public String login(Authentication authResult) {
        if (authResult==null) {
            return "login";
        }
        return "redirect:index";
    }

    @GetMapping("/dangki")
    public String dangki(@ModelAttribute("TaiKhoan") TaiKhoanDTO taiKhoanDTO, Model model) {
        model.addAttribute("TaiKhoan", new TaiKhoanDTO());
        return "dangki";
    }

    @PostMapping("/dangki")
    public String dangkipost(@ModelAttribute("TaiKhoan") TaiKhoanDTO taiKhoanDTO, Model model) {
        model.addAttribute("TaiKhoan", taiKhoanDTO);
        return taiKhoanService.danky(taiKhoanDTO);
    }

    private String common(Authentication authResult) {
        String url = "index";
        if (authResult != null) {
            url = "redirect:main-page";
        }
        return url;
    }

    @GetMapping("/main-page")
    public String mainPage(Authentication authResult, Model model) {
        UserPrincipal userPrincipal = (UserPrincipal) authResult.getPrincipal();
        TaikhoanEntity taikhoan = taiKhoanRepository.findTaikhoanEntityByUsername(userPrincipal.getUsername()).get();
        model.addAttribute("user", taikhoan.getUsername());
        return "main-page";
    }

    @GetMapping("/404")
    public String error() {
        return "404";
    }
}
