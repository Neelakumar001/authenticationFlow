package com.example.AuthendicationFlow.Commen;


import lombok.Data;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Data
public class BadRequest extends RuntimeException{
    List<error>errors;


    public BadRequest(String message, List<error> check) {
        super(message);
        errors=check;
    }
}
