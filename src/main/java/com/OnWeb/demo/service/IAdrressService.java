package com.OnWeb.demo.service;

import java.util.List;

import com.OnWeb.demo.pojos.Address;

public interface IAdrressService {

	List<Address> getAllAddress();

	Address updateAddress(Address adr);

	Address removeAddress(int addressId, int userId);

	Address getAddressById(int addressId);



}
