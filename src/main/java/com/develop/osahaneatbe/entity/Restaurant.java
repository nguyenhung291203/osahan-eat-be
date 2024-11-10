package com.develop.osahaneatbe.entity;

import com.develop.osahaneatbe.listener.RestaurantListener;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "restaurants")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(RestaurantListener.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Restaurant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false, unique = true, length = 50)
    String title;

    @Column(length = 255)
    String subtitle;

    @Column(nullable = false, unique = true, length = 255)
    String address;

    @Column(length = 255)
    String description;

    String image;
    Boolean isFreeShip;
    Boolean isActive;
    LocalTime openTime;
    LocalTime closeTime;

    @Column(nullable = true)
    Double latitude;

    @Column(nullable = true)
    Double longitude;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    List<RatingRestaurant> ratingRestaurants;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    List<MenuRestaurant> menRestaurants;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    List<Promo> promos;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    List<Order> orders;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    List<FavoriteRestaurant> favoriteRestaurants;
}
