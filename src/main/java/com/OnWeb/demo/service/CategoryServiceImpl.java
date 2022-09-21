package com.OnWeb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnWeb.demo.pojos.Category;
import com.OnWeb.demo.repo.ICategoryRepo;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	ICategoryRepo iCategoryRepo;
	
	@Override
	public List<Category> fetchALLCategories() {
		
		return iCategoryRepo.findAll();
	}

}
