package com.OnWeb.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnWeb.demo.pojos.Cart;

public interface ICartRepo extends JpaRepository<Cart, Integer> {

}
