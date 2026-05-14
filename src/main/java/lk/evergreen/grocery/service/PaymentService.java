package lk.evergreen.grocery.service;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class PaymentService {

    /**
     * Simulates tokenization of a card.
     * In a real app, this would call a payment gateway (like Stripe/PayHere).
     */
    public String tokenize(String cardNumber, String cvv) {
        // Just return a random UUID as a mock token
        return "tok_" + UUID.randomUUID().toString().substring(0, 8);
    }

    public String maskCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 4) return "****";
        String last4 = cardNumber.substring(cardNumber.length() - 4);
        return "**** **** **** " + last4;
    }

    public String detectCardType(String cardNumber) {
        if (cardNumber.startsWith("4")) return "Visa";
        if (cardNumber.startsWith("5")) return "Mastercard";
        return "Credit Card";
    }
}
