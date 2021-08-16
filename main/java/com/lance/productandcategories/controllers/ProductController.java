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

import com.lance.productandcategories.models.Product;
import com.lance.productandcategories.services.CategoryService;
import com.lance.productandcategories.services.ProductService;

@Controller
public class ProductController {

	@Autowired 
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	
	//=================Routes for new product===========
	
	@GetMapping("/products/new")
	public String newProductPage(@ModelAttribute Product product) {
		
		return "newproduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String newProductCreate(@Valid @ModelAttribute Product product,
									BindingResult res) {
		
		if(res.hasErrors()) {
			return "newproduct.jsp";
		}
		else {
			productService.createProduct(product);
			return "redirect:/products/new";
		}
	}
	
	
	//====================Routes to add a product to a category======
	
	@GetMapping("/products/{id}")
	public String addProductToCategoryPage(@ModelAttribute("category") Product product,
											@PathVariable("id") Long id, Model model ) {
		
		model.addAttribute("product", productService.findOneProduct(id));
		Product product1 = productService.findOneProduct(id);
		
		model.addAttribute("categories", categoryService.findAllProductsInCategory(product1));
		model.addAttribute("categoriesNotAdd", categoryService.findAllProductsNotInCategory(product1));
		
		return "addproductstocategory.jsp";
	}
	
	@PostMapping("/cateproducts/{id}")
	public String addProductToCategory(@PathVariable("id") Long prodId,
										@RequestParam("category") Long cateId) {

		productService.addProductToCategory(cateId, prodId);
		return "redirect:/products/new";
			
	}
	
}
