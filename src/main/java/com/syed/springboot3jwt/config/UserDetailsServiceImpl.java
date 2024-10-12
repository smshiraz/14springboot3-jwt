package com.syed.springboot3jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.syed.springboot3jwt.entity.UserInfoEntity;
import com.syed.springboot3jwt.repository.UserInfoRepository;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfoEntity> userInfo = repository.findByName(username);
        return userInfo.map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}