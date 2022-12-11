package com.MySocialMedia.Api.DAO;

import com.MySocialMedia.Api.Entities.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao implements IUserDao{

    private IUserLoginRepository _userLoginRepository;
    public UserDao(IUserLoginRepository userLoginRepository){
     _userLoginRepository=userLoginRepository;
    }
    @Override
    public List<UserLogin> getUserLoginList() {
        return _userLoginRepository.findAll();
    }

    @Override
    public UserLogin getUserLoginById(int id) {
        return _userLoginRepository.findById(id);
    }

    @Override
    public void userSignUp(UserLogin userLogin) {

    }
}
