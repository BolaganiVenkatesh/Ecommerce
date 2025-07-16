package com.ecommerce.service;

import com.ecommerce.dto.AddToCartRequest;
import com.ecommerce.dto.CartResponse;

public interface CartService {
    CartResponse addToCart(AddToCartRequest request, String username);
    CartResponse getCart(String username);
    void removeItem(Long itemId, String username);
}
