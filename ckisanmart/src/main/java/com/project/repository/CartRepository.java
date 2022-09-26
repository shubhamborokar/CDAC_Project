package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pojo.Cart;
import com.project.pojo.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	

	List<Cart> findByUser(User u);

	

}
