package com.develop.osahaneatbe.entity;

import com.develop.osahaneatbe.listener.CategoryListener;
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
@EntityListeners(CategoryListener.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    Cart cart;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    Dish dish;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    Restaurant restaurant;

    Long quantity;
}
