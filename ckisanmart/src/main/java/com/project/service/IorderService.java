package com.project.service;

import java.util.List;

import com.project.pojo.Order;

public interface IorderService {

	List<Order> getordersdetails(String name);

	boolean checkQuantity(Order order, String email);

	void Transaction(Order order, String email);

}
