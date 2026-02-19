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

    @PostMapping("/add")
    public ResponseEntity<CartResponse> addToCart(
            @RequestParam Long userId,
            @RequestParam Long productId,
            @RequestParam int quantity
    ) {
        return ResponseEntity.ok(
                cartService.addProductToCart(userId, productId, quantity)
        );
    }

    @GetMapping("/view")
    public ResponseEntity<CartResponse> viewCart(@RequestParam Long userId) {
        return ResponseEntity.ok(
                cartService.getCartByUserId(userId)
        );
    }

    @DeleteMapping("/remove")
    public ResponseEntity<CartResponse> removeItem(
            @RequestParam Long userId,
            @RequestParam Long productId
    ) {
        return ResponseEntity.ok(
                cartService.removeItemFromCart(userId, productId)
        );
    }
}
