package com.MySocialMedia.Api.Service;

import com.MySocialMedia.Api.DAL.IUserLoginRepository;
import com.MySocialMedia.Api.Entities.UserLogin;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginService implements IUserLoginManager{


    private IUserLoginRepository _userLoginRepo;
    public UserLoginService(IUserLoginRepository userLoginRepo){
        _userLoginRepo=userLoginRepo;
    }
    @Override
    public List<UserLogin> getUserLoginList(){
        return _userLoginRepo.findAll();
    }

    @Override
    public UserLogin getUserLoginById(int id) {

        return _userLoginRepo.findById(id);
    }

    @Override
    @Transactional
    public void userSignUp(UserLogin userLogin) {
        _userLoginRepo.save(userLogin);
    }
}
