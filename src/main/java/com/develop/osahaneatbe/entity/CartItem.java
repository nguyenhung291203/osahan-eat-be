package com.develop.osahaneatbe.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "cart_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    Account account;

    @ManyToOne
    @JoinColumn(name = "dish_id", referencedColumnName = "id")
    Dish dish;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    Restaurant restaurant;

    Long quantity;
}
