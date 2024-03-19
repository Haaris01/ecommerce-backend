package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.Models.Orders;
import com.example.demo.Repository.OrderRepo;
import com.example.demo.dmo.OrderDetails;
import com.example.demo.dmo.OrdersList;
import com.example.demo.dto.OrderRequest;
import com.example.demo.dto.OrderResponse;

@Service
public class OrderService {
	@Autowired
	OrderRepo orderrepository;

	private final WebClient webClient;

	public OrderService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://localhost:8060/cart/api/cart").build();
	}

	public Void deleteCartItem(String userId) {
		return webClient.delete()
				.uri("/delete/cart/{userId}", userId)
				.retrieve()
				.bodyToMono(Void.class)
				.block(); // blocking call to wait for the response
	}

	public OrderResponse returnOrders(String userId) {
		Orders orders = orderrepository.findOrderByUserId(userId);
		if (orders == null) {
			throw new RuntimeException("Orders not found for user ID: " + userId);
		}

		return OrderResponse.builder()
				.ordersList(orders.getOrdersList())
				.build();
	}

	public void createOrder(OrderRequest orderrequest) {
		Orders order1 = orderrepository.findOrderByUserId(orderrequest.getUserId());
		if (order1 != null) {
			throw new RuntimeException("Order already exists for user ID: " + orderrequest.getUserId());
		}

		Orders order = Orders.builder()
				.userId(orderrequest.getUserId())
				.ordersList(new ArrayList<>())
				.build();

		OrdersList ol = OrdersList.builder()
				.datePlaced(orderrequest.getOrdersList().getDatePlaced())
				.orderId(orderrequest.getOrdersList().getOrderId())
				.orderDetails(new ArrayList<>())
				.build();

		ArrayList<OrderDetails> orderdetails = new ArrayList<>();
		Iterator<OrderDetails> iter = orderrequest.getOrdersList().getOrderDetails().iterator();
		while (iter.hasNext()) {
			OrderDetails orderdetails1 = iter.next();
			OrderDetails od = OrderDetails.builder()
					.productId(orderdetails1.getProductId())
					.quantity(orderdetails1.getQuantity())
					.deliveryOptionId(orderdetails1.getDeliveryOptionId())
					.build();
			orderdetails.add(od);
		}
		ol.setOrderDetails(orderdetails);
		order.getOrdersList().add(ol);

		deleteCartItem(orderrequest.getUserId());
		orderrepository.save(order);
	}

	public void updateOrder(OrderRequest orderrequest) {
		Orders order = orderrepository.findOrderByUserId(orderrequest.getUserId());
		if (order == null) {
			throw new RuntimeException("Order not found for user ID: " + orderrequest.getUserId());
		}

		Orders order1 = Orders.builder()
				.userId(orderrequest.getUserId())
				.ordersList(new ArrayList<>())
				.build();

		OrdersList ol = OrdersList.builder()
				.datePlaced(orderrequest.getOrdersList().getDatePlaced())
				.orderId(orderrequest.getOrdersList().getOrderId())
				.orderDetails(new ArrayList<>())
				.build();

		ArrayList<OrderDetails> orderdetails = new ArrayList<>();
		Iterator<OrderDetails> iter = orderrequest.getOrdersList().getOrderDetails().iterator();
		while (iter.hasNext()) {
			OrderDetails orderdetails1 = iter.next();
			OrderDetails od = OrderDetails.builder()
					.productId(orderdetails1.getProductId())
					.quantity(orderdetails1.getQuantity())
					.deliveryOptionId(orderdetails1.getDeliveryOptionId())
					.build();
			orderdetails.add(od);
		}
		ol.setOrderDetails(orderdetails);
		order1.getOrdersList().add(ol);

		deleteCartItem(orderrequest.getUserId());
		orderrepository.deleteByUserId(order.getUserId());
		orderrepository.save(order1);
	}
}
