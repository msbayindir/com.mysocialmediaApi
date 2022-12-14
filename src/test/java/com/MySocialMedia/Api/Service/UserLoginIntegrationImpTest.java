package com.MySocialMedia.Api.Service;

import com.MySocialMedia.Api.DAL.IUserLoginRepository;
import com.MySocialMedia.Api.DTO.UserLoginDTO;
import com.MySocialMedia.Api.Entities.UserLogin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserLoginIntegrationImpTest {

    @Autowired
    private UserLoginService _service;
    @Autowired
    private IUserLoginRepository _repo;
    @Test
    void getUserLoginList() {
        List<UserLogin> users = new ArrayList<>();
        users.add(new UserLogin(1,"Hüseyin","23asdase23"));
        users.add(new UserLogin(2,"fatma","23e23da"));
        users.add(new UserLogin(3,"Ayşe","23e2asd3"));

        _repo.saveAll(users);

    List<UserLoginDTO> list =_service.getUserLoginList();
    UserLoginDTO user = list.stream().filter(m->m.getUserName()=="Hüseyin").findAny().orElse(null);


    assertEquals(user.getUserName(),"Hüseyin");
    }
}
