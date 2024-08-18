package com.spring.securitydemo.securitydemo.service;

import com.spring.securitydemo.securitydemo.config.UserInfoUserDetail;
import com.spring.securitydemo.securitydemo.entity.UserInfo;
import com.spring.securitydemo.securitydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userRepository.findByName(username);
        return userInfo.map(UserInfoUserDetail::new)
                .orElseThrow(() -> new UsernameNotFoundException("User Not found for user : " + username));


    }
}
