package com.MySocialMedia.Api.DAO;

import com.MySocialMedia.Api.Entities.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserLoginRepository extends JpaRepository<UserLogin,Integer> {
    public UserLogin findById(int Id);
}
