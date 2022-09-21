package com.OnWeb.demo.service;


import com.OnWeb.demo.pojos.Address;
import com.OnWeb.demo.pojos.User;

public interface IUserService {

	User getUserDetails(int userId);

	User registerAddress(Address address, int userId);

}
