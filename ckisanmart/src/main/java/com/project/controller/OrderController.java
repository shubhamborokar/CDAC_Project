package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.IorderService;

@RestController
@RequestMapping
@CrossOrigin(origins  = "http://localhost:3000")
public class OrderController {

	@Autowired
	private IorderService orderservice;
	
	@GetMapping("/getorders")
	public ResponseEntity<?> getOrders(HttpServletRequest request){
     return new ResponseEntity<>(orderservice.getordersdetails(request.getUserPrincipal().getName()),HttpStatus.OK);		
	}
	
}
