package com.decagon.reward_your_teacher.usecase.services.impl;

import com.decagon.reward_your_teacher.domain.dao.SchoolDao;
import com.decagon.reward_your_teacher.domain.dao.StudentDao;
import com.decagon.reward_your_teacher.domain.entities.SchoolEntity;
import com.decagon.reward_your_teacher.domain.entities.StudentEntity;
import com.decagon.reward_your_teacher.infrastructure.configuration.security.JwtService;
import com.decagon.reward_your_teacher.infrastructure.error_handler.CustomNotFoundException;
import com.decagon.reward_your_teacher.infrastructure.error_handler.EntityAlreadyExistException;
import com.decagon.reward_your_teacher.usecase.payload.request.LoginRequest;
import com.decagon.reward_your_teacher.usecase.payload.request.StudentRegistrationRequest;
import com.decagon.reward_your_teacher.usecase.payload.response.ApiResponse;
import com.decagon.reward_your_teacher.usecase.payload.response.RegistrationResponse;
import com.decagon.reward_your_teacher.usecase.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
    @Service
    @AllArgsConstructor
    public class StudentServiceImpl implements StudentService {
        private final StudentDao studentDao;
        private final SchoolDao schoolDao;
        private final ApiResponse registrationResponse;
        private final AuthenticationManager authenticationManager;
        private final JwtService jwtService;
        private final PasswordEncoder passwordEncoder;
        @Override
        public RegistrationResponse registerStudent(StudentRegistrationRequest studentRegistrationDto) {
            Optional<StudentEntity> tmpStudent = studentDao.findStudent(studentRegistrationDto.getEmail());
            if(tmpStudent.isPresent()){
                throw new EntityAlreadyExistException("Email already taken");
            }

            SchoolEntity school = schoolDao.findSchool(studentRegistrationDto.getSchoolName()).orElseThrow(()-> new CustomNotFoundException("School name not found"));
            StudentEntity student = StudentEntity.builder()
                    .name(studentRegistrationDto.getName())
                    .email(studentRegistrationDto.getEmail())
                    .password(passwordEncoder.encode(studentRegistrationDto.getPassword()))
                    .school(school).build();

            return registrationResponse.created("Success", LocalDateTime.now(),studentDao.saveRecord(student));
        }
        @Override
        public String login(LoginRequest request){
            Authentication auth= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            if(auth.isAuthenticated()){
                String token="Bearer "+jwtService.generateToken(new org.springframework.security.core.userdetails.User(request.getEmail(),request.getPassword(),new ArrayList<>()));
                return  token;
            }else{
                return  "Authentication Failed";
            }
        }

    }
