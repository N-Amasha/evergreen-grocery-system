package lk.evergreen.grocery.controller;

import lk.evergreen.grocery.entity.Cart;
import lk.evergreen.grocery.entity.Product;
import lk.evergreen.grocery.entity.User;
import lk.evergreen.grocery.repository.CartRepository;
import lk.evergreen.grocery.repository.ProductRepository;
import lk.evergreen.grocery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody Map<String, Object> payload) {
        Long userId = Long.valueOf(payload.get("userId").toString());
        Long productId = Long.valueOf(payload.get("productId").toString());
        Integer quantity = Integer.valueOf(payload.get("quantity").toString());

        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Product> productOpt = productRepository.findById(productId);

        if (userOpt.isPresent() && productOpt.isPresent()) {
            User user = userOpt.get();
            Product product = productOpt.get();

            // Check if item already in cart
            Optional<Cart> existingCartItem = cartRepository.findByUserAndProduct(user, product);
            Cart cartItem;

            if (existingCartItem.isPresent()) {
                cartItem = existingCartItem.get();
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
            } else {
                cartItem = new Cart();
                cartItem.setUser(user);
                cartItem.setProduct(product);
                cartItem.setQuantity(quantity);
            }

            cartRepository.save(cartItem);
            return ResponseEntity.ok(Map.of("message", "Item added to cart successfully"));
        }

        return ResponseEntity.badRequest().body(Map.of("message", "User or Product not found"));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Cart>> getUserCart(@PathVariable Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            List<Cart> cartItems = cartRepository.findByUser(userOpt.get());
            return ResponseEntity.ok(cartItems);
        }
        return ResponseEntity.notFound().build();
    }
}
