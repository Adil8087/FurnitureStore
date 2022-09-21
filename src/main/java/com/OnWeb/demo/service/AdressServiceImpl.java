package com.OnWeb.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.OnWeb.demo.repo.IAdrressRepo;

public class AdressServiceImpl implements IAdrressService {

	@Autowired
	IAdrressRepo iAdrressRepo;
}
