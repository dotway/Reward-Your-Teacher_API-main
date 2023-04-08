package com.decagon.reward_your_teacher.usecase.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@Service
public class ApiResponse <T>{
    public RegistrationResponse created(String success,LocalDateTime localDateTime,T payload){
        return new RegistrationResponse(success, localDateTime, payload);
    }

}
