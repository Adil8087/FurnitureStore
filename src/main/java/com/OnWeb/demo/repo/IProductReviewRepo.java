package com.OnWeb.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnWeb.demo.pojos.ProductReview;

public interface IProductReviewRepo extends JpaRepository<ProductReview, Integer> {

}
