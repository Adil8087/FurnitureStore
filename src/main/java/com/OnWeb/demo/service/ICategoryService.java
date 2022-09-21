package com.OnWeb.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OnWeb.demo.pojos.Category;


public interface ICategoryService {

	List<Category> fetchALLCategories();

}
