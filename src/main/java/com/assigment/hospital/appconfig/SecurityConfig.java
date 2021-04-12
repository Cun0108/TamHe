package com.assigment.hospital.appconfig;

import com.assigment.hospital.service.TaiKhoanDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final TaiKhoanDetailsService taiKhoanDetailsService;

    public SecurityConfig(TaiKhoanDetailsService taiKhoanDetailsService) {
        this.taiKhoanDetailsService = taiKhoanDetailsService;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(taiKhoanDetailsService);
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/main-page")
                .hasAnyRole("BACSI", "YVU")
            .antMatchers("/tiepnhanbenhnhan")
                .hasAnyRole("YVU")
            .antMatchers("/hosobenhnhan")
                .hasAnyRole("YVU")
            .antMatchers("/capnhathoso")
                .hasAnyRole("YVU")
            .antMatchers("/timhoso")
                .hasAnyRole("YVU")
            .antMatchers("/danhsachbenhnhannoitru")
                .hasAnyRole("YVU")
            .antMatchers("/timkiembenhnhannoitru")
                .hasAnyRole("YVU")
            .antMatchers("/themlai")
                .hasAnyRole("YVU")
            .antMatchers("/xuylycapnhathoacxoa")
                .hasAnyRole("YVU")
            .antMatchers("/phieuxetnghiem")
                .hasAnyRole("BACSI")
            .antMatchers("/xetnghiem")
                .hasAnyRole("BACSI")
            .antMatchers("/phieukhambenh")
                .hasAnyRole("BACSI")
            .antMatchers("/khambenh")
                .hasAnyRole("BACSI")
            .antMatchers("/ketquaxetnghiem")
                .hasAnyRole("BACSI")
            .antMatchers("/dieutrinoitru")
                .hasAnyRole("BACSI")
            .antMatchers("/updatedieutrinoitru")
                .hasAnyRole("BACSI")
                .antMatchers("/findthuoc")
                .hasAnyRole("BACSI")
            .anyRequest()
                .permitAll()
            .and()
            .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/signin")
                .usernameParameter("username")
                .passwordParameter("password")
            .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
            .and()
                .exceptionHandling()
                .accessDeniedPage("/404");;

    }
}
