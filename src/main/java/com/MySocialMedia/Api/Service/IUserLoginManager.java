package com.MySocialMedia.Api.Service;

import com.MySocialMedia.Api.Entities.UserLogin;

import java.util.List;

public interface IUserLoginManager {
    List<UserLogin> getUserLoginList();
    UserLogin getUserLoginById(int id);
    void userSignUp(UserLogin userLogin);
}
