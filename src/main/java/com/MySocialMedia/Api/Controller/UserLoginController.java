package com.MySocialMedia.Api.Controller;

import com.MySocialMedia.Api.DTO.UserLoginDTO;
import com.MySocialMedia.Api.Service.IUserLoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        return ResponseEntity.ok(_loginManager.getUserLoginList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserLoginDTO> userLoginFindById(@PathVariable int id){

        return ResponseEntity.ok(_loginManager.getUserLoginById(id));
    }

}
