package com.MySocialMedia.Api.Controller;

import com.MySocialMedia.Api.DAO.IUserLoginRepository;
import com.MySocialMedia.Api.Entities.UserLogin;
import com.MySocialMedia.Api.Service.IUserLoginManager;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<UserLogin> userLoginList(){

        return _loginManager.getUserLoginList();
    }
    @GetMapping("/{id}")
    public UserLogin userLoginFindById(@PathVariable int id){

        return _loginManager.getUserLoginById(id);
    }

}
