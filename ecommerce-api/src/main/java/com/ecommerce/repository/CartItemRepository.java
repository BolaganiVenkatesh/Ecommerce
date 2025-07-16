package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
