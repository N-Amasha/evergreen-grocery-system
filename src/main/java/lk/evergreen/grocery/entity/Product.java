package lk.evergreen.grocery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;
    private double price;
    private int stock;
    private String category;
    private double actualWeight;
}
