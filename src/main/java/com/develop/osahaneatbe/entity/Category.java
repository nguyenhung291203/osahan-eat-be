package com.develop.osahaneatbe.entity;

import java.util.List;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false, unique = true, length = 255)
    String name;

    @Column(length = 255)
    String description;

    String image;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    List<MenuRestaurant> menuRestaurants;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    List<Dish> dishes;
}
