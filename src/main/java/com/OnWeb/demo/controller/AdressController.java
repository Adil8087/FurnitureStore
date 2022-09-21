package com.OnWeb.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnWeb.demo.pojos.Address;
import com.OnWeb.demo.pojos.User;
import com.OnWeb.demo.service.IAdrressService;
import com.OnWeb.demo.service.IUserService;

@RestController
@RequestMapping("/address")
public class AdressController {

	@Autowired
	private IAdrressService addressService;

	@Autowired
	private IUserService userService;

	@GetMapping("/list")
	public ResponseEntity<?> listAllAddress() {
		System.out.println("inside listALlAddress controller");
		List<Address> addressList = addressService.getAllAddress();
		if (addressList.size() == 0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Address>>(addressList, HttpStatus.OK);
	}

	@PostMapping("/{userId}")
	public ResponseEntity<?> addAddress(@RequestBody Address address, @PathVariable int userId) {
		User user = userService.registerAddress(address, userId);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/update")
	public ResponseEntity<?> updateAddress(@RequestBody Address adr) {
		Address address = addressService.updateAddress(adr);
		if (address == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Address>(address, HttpStatus.OK);
	}

	@DeleteMapping("/{addressId}/{userId}")
	public ResponseEntity<?> deleteAddress(@PathVariable int addressId, @PathVariable int userId) {
		Address removed = addressService.removeAddress(addressId, userId);
		if (removed == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<Address>(removed, HttpStatus.OK);

	}
	
	@GetMapping("/{addressId}")
	public ResponseEntity<?> getAddressDetails(@PathVariable int addressId)
	{
		
		Address a = addressService.getAddressById(addressId);
		if( a == null ) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Address>(a,HttpStatus.OK);
	}

}
