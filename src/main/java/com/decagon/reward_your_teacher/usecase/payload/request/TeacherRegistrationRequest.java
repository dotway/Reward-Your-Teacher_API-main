package com.decagon.reward_your_teacher.usecase.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class TeacherRegistrationRequest {
    private String name;
    private String email;
    private String password;
    private String school;
    private String yearsOfTeaching;
    private String subjectTaught;
    private String schoolType;
    private MultipartFile image;
}
