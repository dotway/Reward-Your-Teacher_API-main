package com.decagon.reward_your_teacher.infrastructure.controllers;

import com.decagon.reward_your_teacher.usecase.payload.request.LoginRequest;
import com.decagon.reward_your_teacher.usecase.services.impl.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@AllArgsConstructor
@RequestMapping("/api/v1/login")
public class LoginController {

    private final StudentServiceImpl studentService;

    @PostMapping(value = "/student")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(studentService.login(loginRequest), HttpStatus.CREATED);
    }
}
