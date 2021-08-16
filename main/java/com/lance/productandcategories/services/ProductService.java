package com.lance.productandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lance.productandcategories.models.Category;
import com.lance.productandcategories.models.Product;
import com.lance.productandcategories.repos.CategoryRepo;
import com.lance.productandcategories.repos.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired 
	private CategoryRepo categoryRepo;
	
	@Autowired
	private CategoryService categoryService;
	
	
	//create the new product
	public Product createProduct(Product p) {
		return productRepo.save(p);
	}
	
	//Read All
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	//find one product
	public Product findOneProduct(Long id) {
		Optional<Product> optProduct = productRepo.findById(id);
	
		if(optProduct.isPresent()) {
			return optProduct.get();
			
		}else {
			return null;
		}
	}
	
	//add product to category
	public void addProductToCategory(Long categoryID, Long productID) {
		Product thisProduct = findOneProduct(productID);

		Category thisCategory = categoryService.findOneCategory(categoryID);
		
		thisProduct.getCategories().add(thisCategory);
		
		productRepo.save(thisProduct);
		
		
	}
	
	//find all products in this category
	public List<Product> findAllProductsInCategory(Category c){
		
		return productRepo.findAllByCategories(c);
	}
	
	//find all products not in category
	public List<Product> findAllProductsNotInCategory(Category c){
		
		return productRepo.findByCategoriesNotContains(c);
	}
	
	
	
	
	
	
	
	
	
}
