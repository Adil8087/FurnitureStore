package com.OnWeb.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnWeb.demo.pojos.User;

public interface IUserRepo extends JpaRepository<User, Integer> {

}
