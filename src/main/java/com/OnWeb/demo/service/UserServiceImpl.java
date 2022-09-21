package com.OnWeb.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.OnWeb.demo.pojos.Address;
import com.OnWeb.demo.pojos.User;
import com.OnWeb.demo.repo.IUserRepo;

public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepo iUserRepo;

	@Override
	public User getUserDetails(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User registerAddress(Address address, int userId) {
		
		Optional<User> user = iUserRepo.findById(userId);
		if(user.isPresent()) {
			User u= user.get();
			u.addAdress(address);
			iUserRepo.save(u);
			return u;
		}
		
		return null;
	}

	
}
