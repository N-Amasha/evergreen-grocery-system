package lk.evergreen.grocery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private Long orderId;
    private double amount;
    private String status;
}
