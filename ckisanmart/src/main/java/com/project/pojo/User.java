package com.project.pojo;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseEntity {
	
	@Column(length = 20,name = "first_name")
	@NotEmpty(message = "name cannot be empty")
	private String firstName;
	
	@Column(length = 20,name = "last_name")
	@NotEmpty(message = "name cannot be empty")
	private String lastName;
	
	@Column(length = 20, name = "contact")
	@Size(min = 10,max = 10)
	private String contact;
	
	@Column(length = 30,unique = true)
	@Email
	@NotEmpty(message = "email cannot be null")
	private String email;

	@Column(length = 100)
	@NotEmpty(message = "password required")
	private String password;
	
	@Column(length = 20)
	@NotEmpty
	private String role;

	

	
//	@OneToone()
//	@JoinColumn(name="id")
//	List<Cart> cartitems=new ArrayList<>();
//	
//	@OneToMany()
//	@JoinColumn(name="id")
//	List<Product> products=new ArrayList<>();
//	
//	@OneToMany()
//	@JoinColumn(name="id")
//	List<Order>orders=new ArrayList<>();


public User(@NotEmpty(message = "name cannot be empty") String firstName,
		@NotEmpty(message = "name cannot be empty") String lastName, @Size(min = 10, max = 10) String contact,
		@Email @NotEmpty(message = "email cannot be null") String email,
		@NotEmpty(message = "password required") String password, @NotEmpty String role) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.contact = contact;
	this.email = email;
	this.password = password;
	this.role = role;
}










	
	

}