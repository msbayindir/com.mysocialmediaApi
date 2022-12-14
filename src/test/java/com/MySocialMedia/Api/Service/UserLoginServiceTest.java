package com.MySocialMedia.Api.Service;

import com.MySocialMedia.Api.DAL.IUserLoginRepository;
import com.MySocialMedia.Api.DTO.UserLoginDTO;
import com.MySocialMedia.Api.Entities.UserLogin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserLoginServiceTest {

    @Mock
    private IUserLoginRepository _loginRepo;
    @InjectMocks
    private UserLoginService _loginService;

    @Test
    void getUserLoginList() {

        when(_loginRepo.findAll()).thenReturn(List.of(new UserLogin(),new UserLogin()));

       List<UserLoginDTO> result = _loginService.getUserLoginList();

        assertThat(result.size()).isEqualTo(2);

    }

    @Test
    void getUserLoginById() {
        UserLogin newuserLogin = new UserLogin(1,"sefa","123");
        when(_loginRepo.findById(anyInt())).thenReturn(newuserLogin);

        UserLoginDTO result = _loginService.getUserLoginById(1);

        assertEquals("sefa",result.getUserName());


    }
}