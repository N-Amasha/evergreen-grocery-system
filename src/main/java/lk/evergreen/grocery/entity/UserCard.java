package lk.evergreen.grocery.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_cards")
@Data
public class UserCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardHolderName;
    private String maskedCardNumber; // e.g., **** **** **** 4567
    private String expiryDate; // MM/YY
    private String cardType; // Visa, Mastercard, etc.
    private String token; // Mock payment token

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
