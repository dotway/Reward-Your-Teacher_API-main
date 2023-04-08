package com.decagon.reward_your_teacher.usecase.services;

import com.decagon.reward_your_teacher.usecase.payload.request.LoginRequest;
import com.decagon.reward_your_teacher.usecase.payload.request.StudentRegistrationRequest;
import com.decagon.reward_your_teacher.usecase.payload.response.ApiResponse;
import com.decagon.reward_your_teacher.usecase.payload.response.RegistrationResponse;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    RegistrationResponse registerStudent(StudentRegistrationRequest studentRegistrationRequest);
    String login(LoginRequest request);
}

