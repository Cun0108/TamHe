package com.assigment.hospital.service;

import com.assigment.hospital.entity.TaikhoanEntity;
import com.assigment.hospital.repository.TaiKhoanRepository;
import com.assigment.hospital.security.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TaiKhoanDetailsService implements UserDetailsService {

    private final TaiKhoanRepository taiKhoanRepository;

    public TaiKhoanDetailsService(TaiKhoanRepository taiKhoanRepository) {
        this.taiKhoanRepository = taiKhoanRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TaikhoanEntity taikhoanEntity = taiKhoanRepository
                .findTaikhoanEntityByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username " + username));
        return new UserPrincipal(taikhoanEntity);
    }

}
