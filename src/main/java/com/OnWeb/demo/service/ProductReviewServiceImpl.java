package com.OnWeb.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.OnWeb.demo.repo.IProductReviewRepo;

public class ProductReviewServiceImpl implements IProductReviewService{

	@Autowired
	IProductReviewRepo iProductReviewRepo;
}
