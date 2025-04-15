package com.example.AuthendicationFlow.Service;


import com.example.AuthendicationFlow.ApiReapose.ApiResponse;
import com.example.AuthendicationFlow.Commen.BadRequest;
import com.example.AuthendicationFlow.Commen.error;
import com.example.AuthendicationFlow.Dto.RegisterDto;
import com.example.AuthendicationFlow.Model.Register;
import com.example.AuthendicationFlow.Repo.RegisterRepo;
import com.example.AuthendicationFlow.Validater.RegisterValidation;
import com.example.AuthendicationFlow.util.JwtToken;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ApiService {

    @Autowired
    RegisterValidation registerValidation;

    @Autowired
    JwtToken jwtToken;

    @Autowired
    RegisterRepo registerRepo;
    public ApiResponse create(RegisterDto registerDto) {

        ApiResponse apiResponse=new ApiResponse();
        List<error> check = registerValidation.validateTheRegisterData(registerDto);

        if (!check.isEmpty()){
            throw new BadRequest("BadRequest",check);
        }
        Register register=new Register();
        register.setName(registerDto.getName());
        register.setEmailId(registerDto.getEmailId());
        register.setPassword(registerDto.getPassword());
        register.setAge(registerDto.getAge());
        register.setLocation(registerDto.getLocation());

        registerRepo.save(register);

        String token = jwtToken.createToken(register);

        Map<String,Object> data=new HashMap<>();
        data.put("Token",token);
        data.put("UserDetails",register);

        apiResponse.setData(data);

        return apiResponse;
    }

    public ApiResponse login(RegisterDto registerDto) {
        ApiResponse apiResponse=new ApiResponse();
        Register user=registerRepo.findByEmailIdAndPassword(registerDto.getEmailId(),registerDto.getPassword());

        if(user==null){
            apiResponse.setError("User not found.....");
        }
        String token =jwtToken.createToken(user);

        Map<String,Object> jwt=new HashMap<>();
        jwt.put("Token",token);

        apiResponse.setData(jwt);
        return apiResponse;
    }


    public ApiResponse Update(RegisterDto registerDto, long id, String auth) {

        ApiResponse apiResponse=new ApiResponse();
        jwtToken.verifyToken(auth);
        List<error> check = registerValidation.validateTheRegisterData(registerDto);
        if (!check.isEmpty()){
            throw new BadRequest("BadRequest",check);
        }
        List<Register> AllList = registerRepo.findAll();
        for (Register register :AllList) {
        if (register.getId()==id)
       {
               register.setName(registerDto.getName());
               register.setEmailId(registerDto.getEmailId());
               register.setPassword(registerDto.getPassword());
               register.setAge(registerDto.getAge());
               register.setLocation(registerDto.getLocation());
               apiResponse.setData(register);
               registerRepo.save(register);
       }
             }
             return apiResponse;
    }

    public ApiResponse Get(Pageable pageable) {

        ApiResponse apiResponse=new ApiResponse();
        Page<Register> AllUserList = registerRepo.findAll(pageable);
        apiResponse.setData(AllUserList);

        return apiResponse;

    }
}
