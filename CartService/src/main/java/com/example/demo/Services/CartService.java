package com.example.demo.Services;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.CartRepo;
import com.example.demo.dmo.CartItem;
import com.example.demo.dto.CartRequest;
import com.example.demo.dto.CartResponse;
import com.example.demo.models.Cart;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartService {

	@Autowired
	private CartRepo cartrepository;

	public List<CartResponse> getCartByUserId(String userId) {
		try {
			return cartrepository.findByUserId(userId)
					.stream()
					.map(cart -> CartResponse.builder()
							.cts(cart.getCts())
							.build())
					.toList();
		} catch (DataAccessException ex) {
			log.error("Error occurred while fetching cart for user ID: {}", userId, ex);
			throw ex;
		}
	}

	public void createCart(CartRequest cartrequest) {
		try {
			Cart cart = Cart.builder()
					.userId(cartrequest.getUserId())
					.cts(new ArrayList<>())
					.build();

			cart.addItem(cartrequest.getItem());

			cartrepository.save(cart);
		} catch (DataAccessException ex) {
			log.error("Error occurred while creating cart for user ID: {}", cartrequest.getUserId(), ex);
			throw ex;
		}
	}

	public void updateCartByUserId(String userId, CartItem item) {
		try {
			Cart cart = (Cart) cartrepository.findByUserId(userId);
			ArrayList<CartItem> items = cart.getCts();
			Iterator<CartItem> iterator = items.iterator();
			while (iterator.hasNext()) {
				CartItem item1 = iterator.next();
				if (item1.getProductId().equals(item.getProductId())) {
					item1.setQuantity(item1.getQuantity() + item.getQuantity());
					cartrepository.save(cart);
					return;
				}
			}
			cart.addItem(item);
			cartrepository.save(cart);
		} catch (DataAccessException ex) {
			log.error("Error occurred while updating cart for user ID: {}", userId, ex);
			throw ex;
		} catch (NoSuchElementException ex) {
			log.error("Cart not found for user ID: {}", userId, ex);
			throw ex;
		}
	}

	public void deleteItem(String userId, String productIdJson) {
		try {
			String productId = productIdJson.split(":")[1].replaceAll("[\"\\s}]", "");
			Cart cart = (Cart) cartrepository.findByUserId(userId);
			ArrayList<CartItem> items = cart.getCts();
			Iterator<CartItem> iterator = items.iterator();
			while (iterator.hasNext()) {
				CartItem item = iterator.next();
				if (item.getProductId().equals(productId)) {
					iterator.remove();
				}
			}
			cartrepository.save(cart);
		} catch (DataAccessException ex) {
			log.error("Error occurred while deleting item from cart for user ID: {}", userId, ex);
			throw ex;
		} catch (NoSuchElementException ex) {
			log.error("Cart not found for user ID: {}", userId, ex);
			throw ex;
		}
	}

	public void deleteCart(String userId) {
		try {
			cartrepository.deleteByUserId(userId);
		} catch (DataAccessException ex) {
			log.error("Error occurred while deleting cart for user ID: {}", userId, ex);
			throw ex;
		}
	}
}
