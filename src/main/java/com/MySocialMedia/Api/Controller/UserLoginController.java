package com.MySocialMedia.Api.Controller;

import com.MySocialMedia.Api.DTO.UserLoginDTO;
import com.MySocialMedia.Api.Entities.UserLogin;
import com.MySocialMedia.Api.Service.IUserLoginManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/login")
public class UserLoginController {

    @Autowired
    private IUserLoginManager _loginManager;
    public UserLoginController (IUserLoginManager loginManager){
        _loginManager = loginManager;
    }
    @GetMapping
    public ResponseEntity<List<UserLoginDTO>> userLoginList(){
        List<UserLoginDTO> userLoginDTOS = new ArrayList<>();
        _loginManager.getUserLoginList().forEach(userLogin -> userLoginDTOS.add(UserLoginDTO.builder()
                .userName(userLogin.getUserName())
                .password(userLogin.getPassword())
                .id(userLogin.getId()).build()));

        return ResponseEntity.ok(userLoginDTOS);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserLoginDTO> userLoginFindById(@PathVariable int id){
       UserLogin userLogin= _loginManager.getUserLoginById(id);


        return ResponseEntity.ok(UserLoginDTO.builder()
                .userName(userLogin.getUserName())
                .id(userLogin.getId())
                .password(userLogin.getPassword()).build());
    }

    @PostMapping()
    public ResponseEntity<UserLoginDTO> userAdd(@Valid @RequestBody UserLoginDTO userLoginDTO){

       _loginManager.userSignUp(UserLogin.builder()
                .userName(userLoginDTO.getUserName())
                .password(userLoginDTO.getPassword())
                .id(userLoginDTO.getId())
                .build());
        return  ResponseEntity.created(null).body(userLoginDTO);
    }

}
