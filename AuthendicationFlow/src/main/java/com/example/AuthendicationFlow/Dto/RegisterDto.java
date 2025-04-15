package com.example.AuthendicationFlow.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterDto {
    private String name;
    private String emailId;
    private String location;
    private Integer age;
    private String password;

    public RegisterDto(String name, String emailId, String location, int age,String password) {
        this.name = name;
        this.emailId = emailId;
        this.location = location;
        this.age = age;
        this.password=password;
    }




}
