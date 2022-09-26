package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pojo.Order;
import com.project.service.IUserServices;
import com.project.service.IorderService;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping
@CrossOrigin(origins  = "http://localhost:3000")
public class PaymentController {
@Autowired
private IUserServices userService;

@Autowired
private IorderService orderService;

@PostMapping("/payment")
public String Payment(@RequestBody Order order,HttpServletRequest request) {
	System.out.println("in payment");
	try {
		System.out.println(orderService.checkQuantity(order,request.getUserPrincipal().getName()));
	if(orderService.checkQuantity(order, request.getUserPrincipal().getName())) {
		System.out.println(order);
		RazorpayClient  client= new RazorpayClient("rzp_test_DGMZ4HkcUP9PIr","VXnQCrajq6tx0EQoG8AN8KlG");
		JSONObject ob=new JSONObject();
		ob.put("amount", Double.parseDouble(order.getTotalAmount().toString())*100);
		ob.put("currency", "INR");
		ob.put("receipt", "txn_12345");
		com.razorpay.Order create = client.Orders.create(ob);
		return create.toString();
			}
			System.out.println("insuffiecient");
			return "Insufficient Quantity";
	} catch (RazorpayException e) {
		return "bad_Request";
	
	}
}

@PostMapping("/storeorder")
public void storePaymentDetails(@RequestBody Order order ,HttpServletRequest request) {
//	order.setUser(userServices.getUser(request.getUserPrincipal().getName()).orElseThrow());
	System.out.println(" new order "+order);
	orderService.Transaction(order,request.getUserPrincipal().getName());
}







}
