package com.order.management.orderservice.model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="Order_Info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails implements Serializable {
	
	private static final long serialVersionUID = 7640464138951723330L;	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="OrderId")
	private int orderId;
	
	@Column(name="OrderProductId")
	private int orderProductId;
	
	@Column(name="OrderCustomerId")
	private int orderCustomerId;
	
	@Column(name="Quantity")
	private int quantity;
	
	@Column(name="OrderStatus")
	private String orderStatus;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderProductId() {
		return orderProductId;
	}

	public void setOrderProductId(int orderProductId) {
		this.orderProductId = orderProductId;
	}

	public int getOrderCustomerId() {
		return orderCustomerId;
	}

	public void setOrderCustomerId(int orderCustomerId) {
		this.orderCustomerId = orderCustomerId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	

	

	
}
