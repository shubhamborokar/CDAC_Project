package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.IUserServices;

@RestController
@RequestMapping
@CrossOrigin(origins  = "http://localhost:3000")
public class UserController {
    @Autowired
    private IUserServices userServices;
	
	
	@GetMapping("/getinfo")
	 ResponseEntity<?> getUSer(HttpServletRequest request){
		return  ResponseEntity.ok(userServices.getUser(request.getUserPrincipal().getName()));
	}
}
