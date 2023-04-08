package com.decagon.reward_your_teacher.infrastructure.configuration.security;

import com.decagon.reward_your_teacher.domain.dao.StudentDao;
import com.decagon.reward_your_teacher.domain.entities.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthUserService implements UserDetailsService {

    private final StudentDao studentDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StudentEntity user = studentDao.findStudent(username).orElse(null);
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), new ArrayList<>());
    }
}
