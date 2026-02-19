package com.shopforme.core.cart;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /**
     * Add a product to cart
     * Example:
     * POST /api/cart/add?userId=1&productId=2&quantity=3
     */
    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(
            @RequestParam Long userId,
            @RequestParam Long productId,
            @RequestParam int quantity
    ) {
        Cart cart = cartService.addProductToCart(userId, productId, quantity);
        return ResponseEntity.ok(cart);
    }

    /**
     * View cart by user
     * Example:
     * GET /api/cart/view?userId=1
     */
    @GetMapping("/view")
    public ResponseEntity<Cart> viewCart(@RequestParam Long userId) {
        Cart cart = cartService
                .getCartByUserId(userId);
        return ResponseEntity.ok(cart);
    }
}
