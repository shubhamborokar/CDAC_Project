package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pojo.Order;
import com.project.pojo.User;

public interface IOrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByUser(User u);

}
