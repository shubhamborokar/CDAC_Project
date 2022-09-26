package com.project.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@ToString
@Getter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends BaseEntity {
	@Column(length = 20,name = "name")
	@NotEmpty(message = "name cannot be empty")
	String name;
	@Column(name = "image_url")
	@NotEmpty(message = "cannot be empty")
	String imageUrl;
	@Enumerated(value = EnumType.STRING)
	Category category;
	int quantity;
	@Positive
	double rate;
	String description;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	
	public Product(String name,
			String imageUrl, Category category, int quantity,
			double rate, String description) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
		this.category = category;
		this.quantity = quantity;
		this.rate = rate;
		this.description = description;
	}
	
	
	
}
