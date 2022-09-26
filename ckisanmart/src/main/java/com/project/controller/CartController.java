package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.ICartService;

@RestController
@RequestMapping
@CrossOrigin(origins  = "http://localhost:3000")
public class CartController {

	@Autowired
	private ICartService icartservice;
	
	@GetMapping("/getcartproducts")
	public ResponseEntity<?> getproducts(HttpServletRequest request){
		return ResponseEntity.ok(icartservice.getproducts(request.getUserPrincipal().getName()));
	}
	
	@DeleteMapping("/customer/productremovefromcart/{id}")
	ResponseEntity<?>removeFromCart(@PathVariable int id){
		icartservice.removeproductfromcart(id);
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	
	@PutMapping("/increasequantity/{id}")
	public ResponseEntity<?> increasequantity(@PathVariable int id){
		
		icartservice.incresequantity(id);
		return new ResponseEntity<>(HttpStatus.OK);	
		
	}
	@PutMapping("/decreasequantity/{id}")
	public ResponseEntity<?> decreasequantity(@PathVariable int id){
		icartservice.decreasequantity(id);
		return new ResponseEntity<>(HttpStatus.OK);	
		
	}
	
}
