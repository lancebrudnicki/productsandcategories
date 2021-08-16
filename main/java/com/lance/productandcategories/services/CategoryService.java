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
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired 
	private ProductService productService;
	
	//create the new product
	public Category createCategory(Category c) {
		return categoryRepo.save(c);
	}
	
	//Read All
	public List<Category> getAllCategories(){
		return categoryRepo.findAll();
	}
	
	//find one Category
	public Category findOneCategory(Long id) {
		Optional<Category> optCategory = categoryRepo.findById(id);
	
		if(optCategory.isPresent()) {
			return optCategory.get();
			
		}else {
			return null;
		}
	}
	
		
	public void addCategoryToProduct(Long categoryID, Long productID) {
		Category thisCategory = findOneCategory(categoryID);
		
		Product thisProduct = productService.findOneProduct(productID);
		
		thisCategory.getProducts().add(thisProduct);
		
		categoryRepo.save(thisCategory);
				
		}
	
	//find all products in this category
	public List<Category> findAllProductsInCategory(Product p){
		
		return categoryRepo.findAllByProducts(p);
	}
	
	//find all products not in category
	public List<Category> findAllProductsNotInCategory(Product p){
		
		return categoryRepo.findByProductsNotContains(p);
	}
}
