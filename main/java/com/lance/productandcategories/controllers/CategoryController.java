package com.lance.productandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lance.productandcategories.models.Category;
import com.lance.productandcategories.models.Product;
import com.lance.productandcategories.services.CategoryService;
import com.lance.productandcategories.services.ProductService;

@Controller
public class CategoryController {
	@Autowired 
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	
	
	//=============Routes for new Category============
	
	
	@GetMapping("/categories/new")
	public String newProductPage(@ModelAttribute Category category) {
		
		return "newcategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String newProductCreate(@Valid @ModelAttribute Category category,
									BindingResult res) {
		
		if(res.hasErrors()) {
			return "newcategory.jsp";
		}
		else {
			categoryService.createCategory(category);
			return "redirect:/categories/new";
		}
	}

	//========Routes for adding a product to a category========

	
		@GetMapping("/categories/{id}")
		public String addProductToCategoryPage(@PathVariable("id") Long id, Model model ) {
			
			model.addAttribute("category", categoryService.findOneCategory(id));
			Category category1 = categoryService.findOneCategory(id);
			
			model.addAttribute("products", productService.findAllProductsInCategory(category1));
			model.addAttribute("productsNotAdd", productService.findAllProductsNotInCategory(category1));
			
			return "addcategorytoproduct.jsp";
		}
		
		@PostMapping("/prodcategory/{id}")
		public String addProductToCategory(@PathVariable("id") Long cateId,
											@RequestParam("product") Long prodId) {
			categoryService.addCategoryToProduct(cateId, prodId);
			return "redirect:/categories/new";
				
		}
	

}

