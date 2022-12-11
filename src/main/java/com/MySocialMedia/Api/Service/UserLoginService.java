package com.MySocialMedia.Api.Service;

import com.MySocialMedia.Api.DAO.IUserDao;
import com.MySocialMedia.Api.Entities.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserLoginService implements IUserLoginManager{


    private IUserDao _userDao;
    public UserLoginService(IUserDao userDao){
        _userDao=userDao;
    }
    @Override
    public List<UserLogin> getUserLoginList() {
        return _userDao.getUserLoginList();
    }

    @Override
    public UserLogin getUserLoginById(int id) {
        return _userDao.getUserLoginById(id);
    }

    @Override
    public void userSignUp(UserLogin userLogin) {

    }
}
