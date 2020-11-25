package com.order.management.orderservice.controller;

import java.io.FileNotFoundException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.order.management.orderservice.model.OrderDetails;
import com.order.management.orderservice.model.ResponseData;
import com.order.management.orderservice.service.OrderService;
import com.order.management.orderservice.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/order-details")
public class OrderController {
	
	@Autowired
	public OrderService orderService;
	
	@Autowired
	public ReportService report;

	
	@PostMapping("/place/orderDetails")
	public ResponseEntity<ResponseData> placeOrder(@RequestBody OrderDetails orderDetails) {
		
		ResponseData response = new ResponseData();
		try {
			response = orderService.placeOrder(orderDetails);
			if(response.getOrderDetails().getOrderId()!=0) {
				return new ResponseEntity<>(response, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
			}
		}catch (Exception e) {
			response.setMessage("Place Order Failed !!"+e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
		return report.exportReport(format);
	}
	
	@PutMapping("/modify/orderDetails")
	public ResponseEntity<ResponseData> modifyOrder(@RequestBody OrderDetails orderDetails) {
		
		ResponseData response = new ResponseData();
		try {
			response = orderService.modifyOrder(orderDetails);
			if(response.getOrderDetails().getOrderId()!=0) {
				return new ResponseEntity<>(response, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
			}
		}catch (Exception e) {
			response.setMessage("Modify Order Failed !!"+e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@DeleteMapping("/delete/orderDetails")
	public ResponseEntity<ResponseData> deleteOrder(@RequestBody OrderDetails orderDetails) {
		
		ResponseData response = new ResponseData();
		try {
			response = orderService.deleteOrder(orderDetails);
			if(response.getOrderDetails().getOrderId()!=0) {
				return new ResponseEntity<>(response, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
			}
		}catch (Exception e) {
			response.setMessage("Delete Order Failed !!"+e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
