package com.ecommerce.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.AddToCartRequest;
import com.ecommerce.dto.CartResponse;
import com.ecommerce.service.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // ✅ Add product to cart (🔐 Authenticated users)
    @PostMapping("/add")
    public CartResponse addToCart(@RequestBody AddToCartRequest request, Authentication authentication) {
        String username = authentication.getName();
        return cartService.addToCart(request, username);
    }

    // ✅ Get cart for current user (🔐 Authenticated users)
    @GetMapping
    public CartResponse getCart(Authentication authentication) {
        String username = authentication.getName();
        return cartService.getCart(username);
    }

    // ✅ Remove item from cart (🔐 Authenticated users)
    @DeleteMapping("/remove/{itemId}")
    public String removeItem(@PathVariable Long itemId, Authentication authentication) {
        String username = authentication.getName();
        cartService.removeItem(itemId, username);
        return "Item removed from cart.";
    }
}
