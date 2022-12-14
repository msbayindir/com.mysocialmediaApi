package com.MySocialMedia.Api.Service;

import com.MySocialMedia.Api.DAO.IUserLoginRepository;
import com.MySocialMedia.Api.Entities.UserLogin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
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

    List<UserLogin> list =_service.getUserLoginList();
    UserLogin user = list.stream().filter(m->m.getUserName()=="Hüseyin").findAny().orElse(null);


    assertEquals(user.getUserName(),"Hüseyin");
    }
}
