package com.MySocialMedia.Api.Service;

import com.MySocialMedia.Api.DTO.UserLoginDTO;
import com.MySocialMedia.Api.Entities.UserLogin;

import java.util.List;

public interface IUserLoginManager {
    List<UserLoginDTO> getUserLoginList();
    UserLoginDTO getUserLoginById(int id);
    void userSignUp(UserLogin userLogin);
}
