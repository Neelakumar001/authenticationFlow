package com.example.AuthendicationFlow.Validater;

import com.example.AuthendicationFlow.Commen.error;
import com.example.AuthendicationFlow.Dto.RegisterDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegisterValidation {


    public List<error> validateTheRegisterData(RegisterDto registerDto) {
        List<error> errors=new ArrayList<>();

        if(registerDto.getName()==null){
            error error=new error("Name","Name value is null");
            errors.add(error);
        }

        if(registerDto.getEmailId()==null){
            error error=new error("Email","Email value is null");
            errors.add(error);
        }

        if(registerDto.getPassword()==null){
            error error=new error("Password","Password value is null");
            errors.add(error);
        }

        if(registerDto.getAge()==null){
            error error=new error("Age","Age value is null");
            errors.add(error);
        }
        if(registerDto.getLocation()==null){
            error error=new error("Location","location value is null");
            errors.add(error);
        }


        return errors;

    }
}
