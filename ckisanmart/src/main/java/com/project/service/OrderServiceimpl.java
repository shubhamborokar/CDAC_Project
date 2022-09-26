package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.pojo.Cart;
import com.project.pojo.Order;
import com.project.pojo.Product;
import com.project.pojo.User;
import com.project.repository.CartRepository;
import com.project.repository.IOrderRepository;
import com.project.repository.IProductRepository;
import com.project.repository.IUserRepository;

@Service
@Transactional
public class OrderServiceimpl implements IorderService{

	@Autowired
	private IOrderRepository iorderrepo;
	@Autowired
	private IUserRepository iuserrepo;
	@Autowired
	private CartRepository cartrepo;
	@Autowired
	private IProductRepository productrepo;
	@Override
	public List<Order> getordersdetails(String name) {
		User u=iuserrepo.findByEmail(name).orElseThrow();
		
				return iorderrepo.findByUser(u);
	}

	@Override
	public boolean checkQuantity(Order order, String email) {
       boolean check=true;
       System.out.println(order);
       List<Cart> cart=cartrepo.findByUser(iuserrepo.findByEmail(email).orElseThrow());
       for(Cart c:cart) {
    	   System.out.println(c);
    	   Product p=productrepo.findById(c.getProductId()).orElseThrow();
    	   System.out.println(p);
    	   System.out.println(p.getQuantity()-c.getQuantity());
           if((p.getQuantity()-c.getQuantity())<0) {
        	   check=false;
           }
       }
		
		return check;
	}

	@Override
	public void Transaction(Order order, String email) {
		System.out.println("in trasaction");
		if(order.getStatus().equals("paid")) {
			System.out.println("in paid");
			List<Cart> cart=cartrepo.findByUser(iuserrepo.findByEmail(email).orElseThrow());
			for(Cart c: cart){
				System.out.println("in tras "+c);
				Product p=productrepo.findById(c.getProductId()).orElseThrow();
					p.setQuantity(p.getQuantity()-c.getQuantity());
					productrepo.save(p);
			}
	}
		order.setUser(iuserrepo.findByEmail(email).orElseThrow());
		iorderrepo.save(order);
		
	}

}
