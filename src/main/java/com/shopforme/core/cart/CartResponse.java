package com.shopforme.core.cart;

import java.math.BigDecimal;
import java.util.List;

public class CartResponse {

    private final Long cartId;
    private final Long userId;
    private final List<CartItemResponse> items;
    private final BigDecimal totalPrice;

    public CartResponse(
            Long cartId,
            Long userId,
            List<CartItemResponse> items,
            BigDecimal totalPrice
    ) {
        this.cartId = cartId;
        this.userId = userId;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public Long getCartId() { return cartId; }
    public Long getUserId() { return userId; }
    public List<CartItemResponse> getItems() { return items; }
    public BigDecimal getTotalPrice() { return totalPrice; }
}
