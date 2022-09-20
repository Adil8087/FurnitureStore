package com.OnWeb.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnWeb.demo.pojos.Category;
import com.OnWeb.demo.pojos.Product;
import com.OnWeb.demo.repo.ICategoryRepo;
import com.OnWeb.demo.repo.IProductRepo;

@Service
@Transactional
public class ProductServiceImpl implements IProductService{
	@Autowired
	private IProductRepo iProductRepo;
	@Autowired
	private ICategoryRepo iCategoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<Product> listAllGifts() {
		return iProductRepo.findAll();
	}

	@Override
	public Product addProduct(Product product, int catId) {
		Category category=iCategoryRepo.findById(catId).get();
		product.setCreatedOn(LocalDate.now());
		product.setCategories(category);
		return iProductRepo.save(product);
	}

	@Override
	public Optional<Product> searchProduct(int product_id) {
		
		return iProductRepo.findById(product_id);
	}

	@Override
	public Product updateProductDetails(Product product, int product_id) {
		Optional<Product> p=iProductRepo.findById(product_id);
		if(p.get()!=null) {
			Product updated = modelMapper.map(product, Product.class);
			return iProductRepo.save(updated);
		}
		return null;
	}

	@Override
	public Product deleteProduct(int product_id) {
		Optional<Product> p=iProductRepo.findById(product_id);
		iProductRepo.delete(p.get());
		return p.get();
	}

}
