package com.OnWeb.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnWeb.demo.pojos.Category;
import com.OnWeb.demo.service.ICategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	ICategoryService iCategoryService;

	@GetMapping("/list")
	public ResponseEntity<?> getAllCatories(){
		System.out.println("in get all categories");
		List<Category> categories = iCategoryService.fetchALLCategories();
		if(categories.size() == 0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}
	
	
}
