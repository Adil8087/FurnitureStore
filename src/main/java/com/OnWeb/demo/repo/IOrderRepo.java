package com.OnWeb.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnWeb.demo.pojos.Order;

public interface IOrderRepo extends JpaRepository<Order, Integer>{

}
