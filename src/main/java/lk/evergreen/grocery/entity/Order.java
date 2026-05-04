package lk.evergreen.grocery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long userId;
    private double totalAmount;
    private String status;
    private String reconciliationId;
}
