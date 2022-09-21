package com.OnWeb.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.OnWeb.demo.pojos.Address;
import com.OnWeb.demo.pojos.User;
import com.OnWeb.demo.repo.IAdrressRepo;
import com.OnWeb.demo.repo.IUserRepo;

public class AdressServiceImpl implements IAdrressService {

	@Autowired
	IAdrressRepo iAdrressRepo;
	@Autowired
	IUserRepo iIUserRepo;

	@Override
	public List<Address> getAllAddress() {
		
		return iAdrressRepo.findAll();
	}

	@Override
	public Address updateAddress(Address adr) {
		Optional<Address> updated= iAdrressRepo.findById(adr.getAddressId());
		if(updated.isPresent()) {
			iAdrressRepo.save(adr);
			return adr;
		}
		return null;
	}

	@Override
	public Address removeAddress(int addressId, int userId) {
		Optional<User> user= iIUserRepo.findById(userId);
		Optional<Address> adreess = iAdrressRepo.findById(addressId);
		
		if(user.isPresent() && adreess.isPresent()) {
			User presUser= user.get();
			iIUserRepo.save(presUser);
			return adreess.get();
		}
		return null;
	}

	@Override
	public Address getAddressById(int addressId) {
		Optional<Address> adreess = iAdrressRepo.findById(addressId);
		if(adreess.isPresent()) {
			return adreess.get();
		}
		return null;
	}

	
	
}
