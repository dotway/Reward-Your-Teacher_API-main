package com.decagon.reward_your_teacher.infrastructure.error_handler;

import com.decagon.reward_your_teacher.usecase.payload.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<?> UserNotFoundException(CustomNotFoundException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage(),false), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EntityAlreadyExistException.class)
    public ResponseEntity<?> EntityAlreadyExistException(EntityAlreadyExistException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage(),false), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(JwtInvalidException.class)
    public ResponseEntity<?> JwtExceptionHandler(JwtInvalidException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage(),false), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> IllegalJwtExceptionHandler(IllegalArgumentException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage(),false), HttpStatus.BAD_REQUEST);
    }

}
