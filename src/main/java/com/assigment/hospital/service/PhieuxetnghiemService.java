package com.assigment.hospital.service;

import java.sql.Date;
import java.util.List;

import com.assigment.hospital.entity.*;
import com.assigment.hospital.repository.PhieuxetnghiemRepository;

import com.assigment.hospital.repository.TaiKhoanRepository;
import com.assigment.hospital.security.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class PhieuxetnghiemService {

    private final BenhnhanService benhNhanService;
    private final NhanvienService nhanvienService;
    private final XetnghiemService xetnghiemService;
    private final PxnXnService pxnXnService;
    private final PhieuxetnghiemRepository repository;
    private final TaiKhoanRepository taiKhoanRepository;

    public PhieuxetnghiemService(BenhnhanService benhnhanService,
                                 PhieuxetnghiemRepository repository,
                                 XetnghiemService xetnghiemService,
                                 PxnXnService pxnXnService,
                                 NhanvienService nhanvienService,
                                 TaiKhoanRepository taiKhoanRepository) {
        this.benhNhanService = benhnhanService;
        this.repository = repository;
        this.xetnghiemService = xetnghiemService;
        this.pxnXnService = pxnXnService;
        this.nhanvienService = nhanvienService;
        this.taiKhoanRepository = taiKhoanRepository;
    }

    public void savePhieuxetnghiem(long mabn, List<Long> maxn, List<Integer> listketqua, List<String> listghichu, Authentication authResult) {
        BenhnhanEntity benhNhan = benhNhanService.getById(mabn);
        PhieuxetnghiemEntity phieuxetnghiem = new PhieuxetnghiemEntity();
        long millis=System.currentTimeMillis();
        Date ngayThucHien = new Date(millis);
        phieuxetnghiem.setNgaythuchien(ngayThucHien);

        UserPrincipal userPrincipal = (UserPrincipal) authResult.getPrincipal();
        TaikhoanEntity taikhoan = taiKhoanRepository.findTaikhoanEntityByUsername(userPrincipal.getUsername()).get();

        // TODO: Need to change with Current User
        NhanvienEntity nhanVien = taikhoan.getNhanvienByManv();
        // Set name for bac si chi dinh
        phieuxetnghiem.setManv(nhanVien.getManv());
        
        phieuxetnghiem.setMabn(benhNhan.getMaBn());

        phieuxetnghiem = repository.saveAndFlush(phieuxetnghiem);
        
        for (int i = 0; i < maxn.size(); i++) {
            XetnghiemEntity xetnghiem = xetnghiemService.getById(maxn.get(i));
            PxnXnEntity pxnxn = new PxnXnEntity();
            pxnxn.setMapxn(phieuxetnghiem.getMapxn());
            pxnxn.setMaxn(xetnghiem.getMaxn());
            pxnxn.setKetqua(listketqua.get(i));
            pxnxn.setGhichu(listghichu.get(i));
            
            pxnXnService.savePxnXn(pxnxn);
        }
    }

    public PhieuxetnghiemEntity getByMabn(long mabn) {
        List<PhieuxetnghiemEntity> list = repository.findByMabn(mabn);
        if (list.size() > 0) {
            return list.get(list.size() - 1);
        }
        return null;
    }
}
