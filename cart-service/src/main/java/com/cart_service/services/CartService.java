package com.cart_service.services;



import com.cart_service.model.Cart;
import com.cart_service.model.CartItem;
import com.cart_service.repo.CartItemRepository;
import com.cart_service.repo.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    // Create a new cart
    public Cart createCart() {
        Cart cart = new Cart();
        return cartRepository.save(cart);
    }

    // Get a cart by ID
    public Optional<Cart> getCart(Long cartId) {
        return cartRepository.findById(cartId);
    }

    // Add item to cart
    public Cart addItemToCart(Long cartId, CartItem cartItem) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isPresent()) {
            cart.get().addItem(cartItem);
            cartItemRepository.save(cartItem);
            return cartRepository.save(cart.get());
        }
        return null;
    }

    // Remove item from cart
    public Cart removeItemFromCart(Long cartId, Long itemId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isPresent()) {
            CartItem item = cartItemRepository.findById(itemId).orElse(null);
            if (item != null) {
                cart.get().removeItem(item);
                cartItemRepository.delete(item);
                return cartRepository.save(cart.get());
            }
        }
        return null;
    }

    // Get total price of the cart
    public double getCartTotal(Long cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isPresent()) {
            return cart.get().getItems().stream()
                    .mapToDouble(item -> item.getPrice() * item.getQuantity())
                    .sum();
        }
        return 0;
    }
}
