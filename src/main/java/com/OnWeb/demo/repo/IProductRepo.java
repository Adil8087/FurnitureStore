package com.OnWeb.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnWeb.demo.pojos.Product;

public interface IProductRepo extends JpaRepository<Product, Integer>{

}
