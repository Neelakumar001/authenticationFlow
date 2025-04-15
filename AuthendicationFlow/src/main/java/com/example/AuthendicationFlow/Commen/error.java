package com.example.AuthendicationFlow.Commen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class  error {

    private String target;
    private String message;



}
