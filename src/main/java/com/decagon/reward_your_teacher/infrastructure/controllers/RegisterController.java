package com.decagon.reward_your_teacher.infrastructure.controllers;

import com.decagon.reward_your_teacher.usecase.payload.request.StudentRegistrationRequest;
import com.decagon.reward_your_teacher.usecase.payload.request.TeacherRegistrationRequest;
import com.decagon.reward_your_teacher.usecase.payload.response.RegistrationResponse;
import com.decagon.reward_your_teacher.usecase.services.TeacherService;
import com.decagon.reward_your_teacher.usecase.services.impl.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
@Service
@AllArgsConstructor
@RequestMapping("/api/v1/register")
public class RegisterController {

    private final StudentServiceImpl studentService;
    private final TeacherService teacherService;
    @PostMapping(value = "/student")
    public ResponseEntity<RegistrationResponse> registerStudent(@RequestBody StudentRegistrationRequest studentRegistrationRequest){
        return new ResponseEntity<>(studentService.registerStudent (studentRegistrationRequest), HttpStatus.CREATED);
    }
    @PostMapping(value = "/teacher")
    public ResponseEntity<RegistrationResponse> registerTeacher(@RequestBody TeacherRegistrationRequest teacherRegistrationRequest, @RequestPart("image") MultipartFile file){
        return new ResponseEntity<>(teacherService.registerTeacher(teacherRegistrationRequest,file), HttpStatus.CREATED);
    }
}
