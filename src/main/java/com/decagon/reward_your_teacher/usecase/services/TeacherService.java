package com.decagon.reward_your_teacher.usecase.services;

import com.decagon.reward_your_teacher.usecase.payload.request.TeacherRegistrationRequest;
import com.decagon.reward_your_teacher.usecase.payload.response.ApiResponse;
import com.decagon.reward_your_teacher.usecase.payload.response.RegistrationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface TeacherService {
    RegistrationResponse registerTeacher(TeacherRegistrationRequest teacherRegistrationRequest, MultipartFile file);
}
