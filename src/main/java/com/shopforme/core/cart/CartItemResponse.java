package com.shopforme.core.cart;

import java.math.BigDecimal;

public class CartItemResponse {

    private final Long productId;
    private final String productName;
    private final int quantity;
    private final BigDecimal price;
    private final BigDecimal totalPrice;

    public CartItemResponse(
            Long productId,
            String productName,
            int quantity,
            BigDecimal price,
            BigDecimal totalPrice
    ) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public Long getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public BigDecimal getPrice() { return price; }
    public BigDecimal getTotalPrice() { return totalPrice; }
}
