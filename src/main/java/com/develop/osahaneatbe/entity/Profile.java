package com.develop.osahaneatbe.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "profiles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Profile {
    @Id
    String id;

    @Column(nullable = false, length = 100)
    String fullName;

    boolean gender;
    String avatar;

    @Column(name = "data_of_birth")
    LocalDate dateOfBirth;

    @Column(length = 255)
    String address;

    @Column(length = 255, unique = true)
    String email;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    Account account;


}
