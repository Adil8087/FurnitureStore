package com.OnWeb.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OnWeb.demo.pojos.Address;

@Repository
public interface IAdrressRepo extends JpaRepository<Address, Integer> {

}
