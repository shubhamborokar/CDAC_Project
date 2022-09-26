package com.project.service;

import java.util.List;

import com.project.dto.CartDTO;
import com.project.pojo.Product;

public interface IProductServices {

	Product addProducts(Product product,String email);

	Product getProduct(int id);

	void editProduct(Product product, String name);

	void removeProduct(int id);

	List<Product> getProducts(String name);

	List<Product> getProductsByCategory(String category);

	List<Product> getProductsByName(String name);

	void addToCart(CartDTO product, String name);

}
