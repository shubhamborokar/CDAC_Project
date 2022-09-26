package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.CartDTO;
import com.project.pojo.Cart;
import com.project.pojo.Category;
import com.project.pojo.Product;
import com.project.pojo.User;
import com.project.repository.CartRepository;
import com.project.repository.IProductRepository;
import com.project.repository.IUserRepository;
@Service
@Transactional
public class ProductServiceImpl implements IProductServices {
    @Autowired
	private IProductRepository iproductrepo;
    @Autowired
    private IUserRepository iuserrepo;
    @Autowired
	CartRepository icartrepo;
    
    @Override
	public Product addProducts(Product product, String email) {
		User u=iuserrepo.findByEmail(email).orElseThrow();
		product.setUser(u);
		return iproductrepo.save(product);
	}

	@Override
	public Product getProduct(int id) {
		
		return iproductrepo.findById(id).orElseThrow();
	}

	@Override
	public void editProduct(Product product, String name) {
		User u=iuserrepo.findByEmail(name).orElseThrow();
		product.setUser(u);
		iproductrepo.save(product);
		
		
	}

	@Override
	public void removeProduct(int id) {
		iproductrepo.deleteById(id);
	}

	@Override
	public List<Product> getProducts(String name) {
		User u=iuserrepo.findByEmail(name).orElseThrow();
		return iproductrepo.findByUser(u);
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		
		return iproductrepo.findByCategory(Category.valueOf(category.toUpperCase()));
	}

	@Override
	public List<Product> getProductsByName(String name) {
		
		return iproductrepo.findByName("%"+name+"%");
	}

	@Override
	public void addToCart(CartDTO product, String name) {
		User u=iuserrepo.findByEmail(name).orElseThrow();
		Product p=getProduct(product.getProductId());
		iproductrepo.save(p);
		Cart c=new Cart(p.getId(),p.getName(),p.getImageUrl(),product.getQuantity(),p.getRate(),u);
		icartrepo.save(c);
		
	}

	
	

}
