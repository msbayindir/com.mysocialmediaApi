package com.MySocialMedia.Api.Service;

import com.MySocialMedia.Api.DAL.IUserLoginRepository;
import com.MySocialMedia.Api.DTO.UserLoginDTO;
import com.MySocialMedia.Api.Entities.UserLogin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserLoginService implements IUserLoginManager{


    private IUserLoginRepository _userLoginRepo;
    public UserLoginService(IUserLoginRepository userLoginRepo){
        _userLoginRepo=userLoginRepo;
    }
    @Override
    public List<UserLoginDTO> getUserLoginList(){
        List<UserLoginDTO> userLoginDTOS = new ArrayList<>();
        _userLoginRepo.findAll().forEach(userLogin -> userLoginDTOS.add(UserLoginDTO.builder()
                .userName(userLogin.getUserName())
                .password(userLogin.getPassword())
                .id(userLogin.getId()).build()));
        return userLoginDTOS;


    }

    @Override
    public UserLoginDTO getUserLoginById(int id) {

        return UserLoginDTO.builder()
                .userName(_userLoginRepo.findById(id).getUserName())
                .password(_userLoginRepo.findById(id).getPassword())
                .id(_userLoginRepo.findById(id).getId()).build();
    }

    @Override
    public void userSignUp(UserLogin userLogin) {

    }
}
