package com.project.service;

import java.util.List;

import com.project.pojo.Cart;
import com.project.pojo.Product;

public interface ICartService {

	List<Cart> getproducts(String name);

	void removeproductfromcart(int id);

	void incresequantity(int id);

	void decreasequantity(int id);

}
