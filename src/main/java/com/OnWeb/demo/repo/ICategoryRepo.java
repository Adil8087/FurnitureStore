package com.OnWeb.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnWeb.demo.pojos.Category;

public interface ICategoryRepo extends JpaRepository<Category, Integer> {

}
