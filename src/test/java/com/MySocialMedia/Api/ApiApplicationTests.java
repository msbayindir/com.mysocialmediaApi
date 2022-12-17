package com.MySocialMedia.Api;

import com.MySocialMedia.Api.DAL.IUserLoginRepository;
import com.MySocialMedia.Api.Entities.UserLogin;
import com.MySocialMedia.Api.Service.IUserLoginManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApiApplicationTests {

	@Autowired
	private IUserLoginManager _manager;
	@Autowired
	private IUserLoginRepository _repo;
	@Test
	void getUserLoginListTest() {

		_repo.save(new UserLogin(1,"Kasım","1234"));
		_repo.save(new UserLogin(2,"Berke","12345"));
		_repo.save(new UserLogin(3,"Sefa","12346"));
		List<UserLogin>repoUserList= _repo.findAll();
		List< UserLogin> users= _manager.getUserLoginList();

		assertEquals(repoUserList.size(),users.size());
	}
	@Test
	void getUserLoginByIdTest() {

		_repo.save(new UserLogin(1,"Kasım","1234"));
		_repo.save(new UserLogin(2,"Berke","12345"));
		_repo.save(new UserLogin(3,"Sefa","12346"));
		UserLogin repoUser= _repo.findById(1);

		assertEquals("Kasım",repoUser.getUserName());
	}

}
