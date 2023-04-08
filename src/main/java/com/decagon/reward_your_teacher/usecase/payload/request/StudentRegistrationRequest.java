package com.decagon.reward_your_teacher.usecase.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentRegistrationRequest {
    private String name;
    private String email;
    private String password;
    private String schoolName;
}
