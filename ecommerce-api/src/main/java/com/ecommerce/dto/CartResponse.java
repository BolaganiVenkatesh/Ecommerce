package com.ecommerce.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.ecommerce.model.Cart;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartResponse {
    private Long cartId;
    private List<CartItemResponse> items;
    private double total;

    public static CartResponse from(Cart cart) {
        List<CartItemResponse> itemResponses = cart.getItems().stream()
                .map(CartItemResponse::from)
                .collect(Collectors.toList());

        double total = itemResponses.stream().mapToDouble(CartItemResponse::getPrice).sum();

        return CartResponse.builder()
                .cartId(cart.getId())
                .items(itemResponses)
                .total(total)
                .build();
    }
}
