package com.project.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

	@Column(name = "total_amount")
	private String totalAmount;
	@Column(name = "full_name")	
	private String fullName;
	private String contact;
	private String pincode;
	private String state;
	private String city;
	private String line1;
	private String line2;
	@Column(name="payment_id")
	private String paymentId;
	@Column(name="order_id")
	private String orderId;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	/**
	 * @param totalAmount
	 * @param fullName
	 * @param contact
	 * @param pincode
	 * @param state
	 * @param city
	 * @param line1
	 * @param line2
	 * @param paymentId
	 * @param orderId
	 * @param user
	 */
	public Order(String totalAmount, String fullName, String contact, String pincode, String state, String city,
			String line1, String line2, String paymentId, String orderId, User user) {
		super();
		this.totalAmount = totalAmount;
		this.fullName = fullName;
		this.contact = contact;
		this.pincode = pincode;
		this.state = state;
		this.city = city;
		this.line1 = line1;
		this.line2 = line2;
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.user = user;
	}


	
	
	
}
