package com.OnWeb.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.OnWeb.demo.pojos.Product;
import com.OnWeb.demo.pojos.ProductReview;
import com.OnWeb.demo.service.ICategoryService;
import com.OnWeb.demo.service.IProductService;

@RestController
public class HomeController {

	@Autowired
	IProductService iProductService;
	
	@Autowired
	ICategoryService iCategoryService;
	
	@GetMapping("/product")
	public ResponseEntity<?> getAllProduct(){
		System.out.println("in get all gifts");
		List<Product> products = iProductService.listAllGifts();
		if(products.size() == 0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@PostMapping("/add/{cat_id}")
	public ResponseEntity<?> addProductInCategory(@RequestBody Product product, @PathVariable int cat_id,@RequestParam MultipartFile imageFile) {
		try {
			Product added= iProductService.addProduct(product, cat_id,  imageFile);
			return new ResponseEntity<Product>(added, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/product/{product_id}")
	public ResponseEntity<?> getProductDetails(@PathVariable int product_id){
		System.out.println("in product details");
		 Optional<Product> p = iProductService.searchProduct(product_id);
		if(p.get() !=null )
			return new ResponseEntity<Product>(p.get(), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/product/update/{product_id}")
	public ResponseEntity<?> updateProductDetails(@RequestBody Product product,@PathVariable int product_id){
		System.out.println("in update product details");
		Product p= iProductService.updateProductDetails(product, product_id);
		if(p == null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Product>(p, HttpStatus.OK);	
	}
	
	@DeleteMapping("/product/delete/{product_id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int product_id) {
		System.out.println("in delete gift");
		try {
			 Product deleted = iProductService.deleteProduct(product_id);
			return new ResponseEntity<Product>(deleted, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	@GetMapping("/product/listReviews/{pId}")
	public ResponseEntity<?> getAllReviewsOfProduct(@PathVariable int pId){
		System.out.println("in get all gifts");
		List<ProductReview> review = iProductService.findReview(pId);
		if(review.size() == 0)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<ProductReview>>(review, HttpStatus.OK);
	}
	
}
