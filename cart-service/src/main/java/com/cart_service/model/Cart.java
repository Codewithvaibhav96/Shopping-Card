package com.cart_service.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private List<CartItem> items;

    public Cart(List<CartItem> items) {
        this.items = items;
    }

    public Cart(Long id, List<CartItem> items) {
        this.id = id;
        this.items = items;
    }

    public Cart() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public void addItem(CartItem cartItem) {
    }

    public void removeItem(CartItem item) {
    }
}
