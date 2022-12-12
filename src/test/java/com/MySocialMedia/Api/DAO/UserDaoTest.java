package com.MySocialMedia.Api.DAO;

import com.MySocialMedia.Api.Entities.UserLogin;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserDaoTest {


    @Autowired
    private IUserLoginRepository _userLoginRepo;

    @Test
    void getUserLoginList() {
    List<UserLogin> userLoginList = _userLoginRepo.findAll();
    assertEquals(2,userLoginList.stream().count());
    }

    @Test
    void getUserLoginById() {

        UserLogin result =_userLoginRepo.findById(1);

        assertNotNull(result);
    }
}