package com.order.management.orderservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.order.management.orderservice.model.OrderDetails;
import com.order.management.orderservice.model.ResponseData;
import com.order.management.orderservice.repository.OrderRepository;

@Service
public class OrderService {
	
	
	@Autowired
	OrderRepository order;
	
	public ResponseData placeOrder(OrderDetails orderDetails) {
		
			OrderDetails placeOrder = new OrderDetails();
			ResponseData response = new ResponseData();
			placeOrder.setOrderId(orderDetails.getOrderId());
			placeOrder.setOrderCustomerId(orderDetails.getOrderCustomerId());
			placeOrder.setOrderProductId(orderDetails.getOrderProductId());
			placeOrder.setQuantity(orderDetails.getQuantity());
			placeOrder.setOrderStatus(orderDetails.getOrderStatus());
			
					
			order.saveAndFlush(placeOrder);	
			response.setOrderDetails(placeOrder);
			response.setMessage("Order Placed successfully");
		
			return response;
			
	}
	
	
	public ResponseData modifyOrder(OrderDetails orderDetails) {
		
		OrderDetails modifyOrder = new OrderDetails();
		ResponseData response = new ResponseData();
		modifyOrder.setOrderId(orderDetails.getOrderId());
		modifyOrder.setOrderCustomerId(orderDetails.getOrderCustomerId());
		modifyOrder.setOrderProductId(orderDetails.getOrderProductId());
		modifyOrder.setQuantity(orderDetails.getQuantity());
		modifyOrder.setOrderStatus(orderDetails.getOrderStatus());
		
				
		order.save(modifyOrder);	
		response.setOrderDetails(modifyOrder);
		response.setMessage("Order Modified successfully");
	
		return response;
		
    }

	
	public ResponseData deleteOrder(OrderDetails orderDetails) {
		
		OrderDetails deleteOrder = new OrderDetails();
		ResponseData response = new ResponseData();
		deleteOrder.setOrderId(orderDetails.getOrderId());
		deleteOrder.setOrderCustomerId(orderDetails.getOrderCustomerId());
		deleteOrder.setOrderProductId(orderDetails.getOrderProductId());
		deleteOrder.setQuantity(orderDetails.getQuantity());
		deleteOrder.setOrderStatus(orderDetails.getOrderStatus());
		
				
		order.deleteById(deleteOrder.getOrderId());	
		response.setOrderDetails(deleteOrder);
		response.setMessage("Order Deleted successfully");
	
		return response;
		
     }


}
