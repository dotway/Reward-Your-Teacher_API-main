package com.decagon.reward_your_teacher.usecase.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class RegistrationResponse<T> {
    private String message;
    private LocalDateTime timeStamp;
    private T payLoad ;
}
