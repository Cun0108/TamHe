package com.assigment.hospital.security;

import com.assigment.hospital.entity.TaikhoanEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {
    private final TaikhoanEntity taikhoanEntity;

    public UserPrincipal(TaikhoanEntity taikhoanEntity) {
        this.taikhoanEntity = taikhoanEntity;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(this.taikhoanEntity.getRole()));
        return list;
    }

    @Override
    public String getPassword() {
        return this.taikhoanEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return this.taikhoanEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
