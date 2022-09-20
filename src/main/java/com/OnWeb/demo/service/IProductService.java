package com.OnWeb.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.OnWeb.demo.pojos.Product;

@Service
public interface IProductService {

	List<Product> listAllGifts();

	Product addProduct(Product product, int catId);

	Optional<Product> searchProduct(int product_id);

	Product updateProductDetails(Product product, int product_id);

	Product deleteProduct(int product_id);

}
