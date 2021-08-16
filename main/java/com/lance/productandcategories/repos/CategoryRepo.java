package com.lance.productandcategories.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lance.productandcategories.models.Category;
import com.lance.productandcategories.models.Product;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {

	List<Category> findAll();
	
	List<Category> findAllByProducts(Product product);

	List<Category> findByProductsNotContains(Product product);
}
