package com.homework.springhomework.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
@ControllerAdvice
public class ExceptionHelper {

    @ExceptionHandler(value = {StudentNotFoundException.class})
    public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException e){
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiException apiException=new ApiException(e.getMessage(), notFound,ZonedDateTime.now(ZoneId.of("Z")));
        log.error("Student Not Found Exception: "+ e.getMessage());
        return new ResponseEntity<>(apiException, notFound);
    }

    @ExceptionHandler(value = GenderNotFoundException.class)
    public ResponseEntity<Object> handleGenderNotFoundException(GenderNotFoundException e){
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiException apiException=new ApiException(e.getMessage(), notFound,ZonedDateTime.now(ZoneId.of("Z")));
        log.error("Gender Not Found Exception: "+ e.getMessage());
        return new ResponseEntity<>(apiException, notFound);
    }

}
