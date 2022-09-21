package com.OnWeb.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.OnWeb.demo.pojos.Product;
import com.OnWeb.demo.pojos.ProductReview;

@Service
public interface IProductService {

	List<Product> listAllGifts();

	Product addProduct(Product product, int catId, MultipartFile imageFile) throws IOException;

	Optional<Product> searchProduct(int product_id);

	Product updateProductDetails(Product product, int product_id);

	Product deleteProduct(int product_id);

	List<ProductReview> findReview(int pId);

}
