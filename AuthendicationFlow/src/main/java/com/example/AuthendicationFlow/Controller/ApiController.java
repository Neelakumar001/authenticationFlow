package com.example.AuthendicationFlow.Controller;


import com.example.AuthendicationFlow.ApiReapose.ApiResponse;
import com.example.AuthendicationFlow.Dto.RegisterDto;
import com.example.AuthendicationFlow.Service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @Autowired
    ApiService apiService;


    @PostMapping("/api/create")
    public ResponseEntity <ApiResponse> create(@RequestBody RegisterDto registerDto){

        ApiResponse apiResponse = apiService.create(registerDto);

        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }


    @PostMapping("/api/login")
    public ResponseEntity<ApiResponse>Login(@RequestBody RegisterDto registerDto ){
        ApiResponse apiResponse =apiService.login(registerDto);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

    }

    @PutMapping("/api/update/{id}")
    public ResponseEntity<ApiResponse>Update(@RequestBody RegisterDto registerDto, @PathVariable("id")long id,@RequestHeader(value="Auth",defaultValue = " ") String auth){
        ApiResponse apiResponse =apiService.Update(registerDto,id,auth);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

    }

    @GetMapping("/api/allList/")
    public ResponseEntity<ApiResponse>Get(Pageable pageable){
        ApiResponse apiResponse =apiService.Get(pageable);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

    }




}
