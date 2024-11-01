package com.develop.osahaneatbe.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "dishes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Dish extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false, unique = true, length = 255)
    String name;

    @Column(length = 255)
    String description;

    @Column(name = "is_free_ship")
    Boolean isFreeShip;

    @Column(name = "time_ship")
    String timeShip;

    BigDecimal price;

    String image;

    @Column(name = "is_active")
    Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    List<RatingDish> ratingDishes;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    List<OrderDetail> orderDetails;
}
