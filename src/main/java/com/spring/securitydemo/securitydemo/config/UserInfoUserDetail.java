package com.spring.securitydemo.securitydemo.config;

import com.spring.securitydemo.securitydemo.entity.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoUserDetail implements UserDetails {
    private String name;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInfoUserDetail(UserInfo userInfo) {
        this.name = userInfo.getName();
        this.password = userInfo.getPassword();
        this.authorities = Arrays.stream(userInfo.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

}
