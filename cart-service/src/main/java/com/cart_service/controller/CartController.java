package com.cart_service.controller;



import com.cart_service.model.Cart;
import com.cart_service.model.CartItem;
import com.cart_service.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // Create a new cart
    @PostMapping
    public ResponseEntity<Cart> createCart() {
        Cart cart = cartService.createCart();
        return ResponseEntity.ok(cart);
    }

    // Get cart details
    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long cartId) {
        return cartService.getCart(cartId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add item to the cart
    @PostMapping("/{cartId}/items")
    public ResponseEntity<Cart> addItem(@PathVariable Long cartId, @RequestBody CartItem cartItem) {
        Cart updatedCart = cartService.addItemToCart(cartId, cartItem);
        if (updatedCart != null) {
            return ResponseEntity.ok(updatedCart);
        }
        return ResponseEntity.notFound().build();
    }

    // Remove item from the cart
    @DeleteMapping("/{cartId}/items/{itemId}")
    public ResponseEntity<Cart> removeItem(@PathVariable Long cartId, @PathVariable Long itemId) {
        Cart updatedCart = cartService.removeItemFromCart(cartId, itemId);
        if (updatedCart != null) {
            return ResponseEntity.ok(updatedCart);
        }
        return ResponseEntity.notFound().build();
    }

    // Get cart total
    @GetMapping("/{cartId}/total")
    public ResponseEntity<Double> getCartTotal(@PathVariable Long cartId) {
        double total = cartService.getCartTotal(cartId);
        return ResponseEntity.ok(total);
    }
}


