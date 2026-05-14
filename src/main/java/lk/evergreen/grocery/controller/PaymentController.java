package lk.evergreen.grocery.controller;

import lk.evergreen.grocery.entity.User;
import lk.evergreen.grocery.entity.UserCard;
import lk.evergreen.grocery.repository.UserCardRepository;
import lk.evergreen.grocery.repository.UserRepository;
import lk.evergreen.grocery.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private UserCardRepository userCardRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserCard>> getUserCards(@PathVariable Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            return ResponseEntity.ok(userCardRepository.findByUser(userOpt.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCard(@RequestBody Map<String, Object> payload) {
        Long userId = Long.valueOf(payload.get("userId").toString());
        String cardNumber = payload.get("cardNumber").toString().replaceAll("\\s+", "");
        String cvv = payload.get("cvv").toString();

        Optional<User> userOpt = userRepository.findById(userId);

        if (userOpt.isPresent()) {
            UserCard card = new UserCard();
            card.setUser(userOpt.get());
            card.setCardHolderName(payload.get("cardHolderName").toString());
            card.setExpiryDate(payload.get("expiryDate").toString());

            // Security: Use Service to mask and tokenize
            card.setMaskedCardNumber(paymentService.maskCardNumber(cardNumber));
            card.setCardType(paymentService.detectCardType(cardNumber));
            card.setToken(paymentService.tokenize(cardNumber, cvv));

            userCardRepository.save(card);
            return ResponseEntity.ok(Map.of("message", "Card saved successfully", "card", card));
        }
        return ResponseEntity.badRequest().body(Map.of("message", "User not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable Long id) {
        if (userCardRepository.existsById(id)) {
            userCardRepository.deleteById(id);
            return ResponseEntity.ok(Map.of("message", "Card removed successfully"));
        }
        return ResponseEntity.notFound().build();
    }
}
