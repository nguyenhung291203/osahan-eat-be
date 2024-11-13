package com.develop.osahaneatbe.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(unique = true, nullable = false, length = 10)
    String username;

    @Column(nullable = false)
    String password;

    @Column(name = "is_active")
    boolean isActive;

    @Column(name = "facebook_account_id")
    String facebookAccountId;

    @Column(name = "google_account_id")
    String googleAccountId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    Profile profile;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    List<RatingDish> ratingDishes;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    List<RatingRestaurant> ratingRestaurants;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    List<Order> orders;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    List<FavoriteRestaurant> favoriteRestaurants;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    Cart cart;
}
