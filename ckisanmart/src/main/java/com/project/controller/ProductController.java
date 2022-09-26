package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.CartDTO;
import com.project.pojo.Product;
import com.project.service.IProductServices;



@RestController
@RequestMapping
@CrossOrigin(origins  = "http://localhost:3000")
public class ProductController {
	@Autowired
	private IProductServices productServices;
	
	//1)add product
	@PostMapping("/vendor/addproduct")
	public ResponseEntity<?> addProduct(@RequestBody Product product, HttpServletRequest request){
		
		return  ResponseEntity.ok(productServices.addProducts(product,request.getUserPrincipal().getName()));
		
	}
	//2)getproduct by id
	@GetMapping("/getproduct/{id}")
	ResponseEntity<?>getProduct(@PathVariable int id){
		return ResponseEntity.ok(productServices.getProduct(id));
	}
//	3)updateproduct
	@PutMapping("/vendor/editproduct")
	ResponseEntity<?>editProduct(@RequestBody Product product, HttpServletRequest request){
		productServices.editProduct(product,request.getUserPrincipal().getName());
		return new ResponseEntity<>(HttpStatus.OK);
	}
//	4)deleteproduct
	@DeleteMapping("/vendor/productremove/{id}")
	void removeProduct(@PathVariable int id, HttpServletRequest request){
		productServices.removeProduct(id) ;
	}
//	5)getallproducts
	@GetMapping("/allvendorproducts")
	ResponseEntity<?>getProducts(HttpServletRequest request){
		return ResponseEntity.ok(productServices.getProducts(request.getUserPrincipal().getName()));
	}
//	6)get products by category
	@GetMapping("/getproducts/{category}")
	ResponseEntity<?>getFruits(@PathVariable String category, HttpServletRequest request){
		return ResponseEntity.ok(productServices.getProductsByCategory(category));
	}
//	7)get product by name
	@GetMapping("/searchproducts/{name}")
	ResponseEntity<?>searchProduct(@PathVariable String name){
		
		return ResponseEntity.ok(productServices.getProductsByName(name));
	}
//	8)add to cart
	@PostMapping("/customer/addtocart")
	ResponseEntity<?>addToCart(@RequestBody CartDTO product, HttpServletRequest request){
		System.out.println("in add");
		productServices.addToCart(product,request.getUserPrincipal().getName());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

}
