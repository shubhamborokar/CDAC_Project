package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.pojo.Cart;
import com.project.pojo.Product;
import com.project.pojo.User;
import com.project.repository.CartRepository;
import com.project.repository.IUserRepository;

@Service
@Transactional
public class CartServiceImpl implements ICartService {

	@Autowired
	private CartRepository cartrepo;
	@Autowired
	private IUserRepository userrepo;
	@Override
	public List<Cart> getproducts(String name) {
		User u=userrepo.findByEmail(name).orElseThrow();
		return cartrepo.findByUser(u);
	}
	@Override
	public void removeproductfromcart(int id) {
		
		 cartrepo.deleteById(id);
	}
	@Override
	public void incresequantity(int id) {
		Cart c=cartrepo.findById(id).orElseThrow();
		
		c.setQuantity(c.getQuantity()+1);;
		cartrepo.save(c);
		
	}
	@Override
	public void decreasequantity(int id) {
		Cart c=cartrepo.findById(id).orElseThrow();
	    if(c.getQuantity()!=0)
		c.setQuantity(c.getQuantity()-1);;
		cartrepo.save(c);
	}

}
