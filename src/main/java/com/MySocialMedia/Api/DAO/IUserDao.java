package com.MySocialMedia.Api.DAO;


import com.MySocialMedia.Api.Entities.UserLogin;

import java.util.List;

public interface IUserDao {
    List<UserLogin> getUserLoginList();
    UserLogin getUserLoginById(int id);
    void userSignUp(UserLogin userLogin);

}
