package com.spring.securitydemo.securitydemo.service;

import com.spring.securitydemo.securitydemo.entity.UserInfo;
import com.spring.securitydemo.securitydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;
    public Long addUser(UserInfo user){
        user.setPassword(encoder.encode(user.getPassword()));
        UserInfo savedUser = userRepository.save(user);
        return savedUser.getId();
    }

}
