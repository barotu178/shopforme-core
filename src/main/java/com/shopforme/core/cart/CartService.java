package com.shopforme.core.cart;

import com.shopforme.core.product.Product;
import com.shopforme.core.product.ProductRepository;
import com.shopforme.core.user.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Transactional
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    public CartService(
            CartRepository cartRepository,
            CartItemRepository cartItemRepository,
            ProductRepository productRepository
    ) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    public Cart addProductToCart(Long userId, Long productId, int quantity) {

        // 1. Fetch product
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // 2. Validate stock
        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }

        // 3. Get or create cart
        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUser(new User(userId));
                    return cartRepository.save(newCart);
                });

        // 4. Check if product already in cart
        CartItem cartItem = cartItemRepository
                .findByCartIdAndProductId(cart.getId(), productId)
                .orElse(null);

        if (cartItem == null) {
            cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItem.setPriceAtAdded(product.getPrice());
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        }

        cartItemRepository.save(cartItem);
        return cart;
    }
    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found for user"));
    }

}
