package com.develop.osahaneatbe.repository;

import com.develop.osahaneatbe.dto.request.RestaurantFilterRequest;
import com.develop.osahaneatbe.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
    boolean existsByTitle(String title);

    boolean existsByAddress(String address);

    @Query(value = "SELECT r FROM Restaurant r " +
            "WHERE (:#{#filter.accountId} IS NULL OR r.id IN (SELECT fr.restaurant.id FROM FavoriteRestaurant fr WHERE fr.account.id = :#{#filter.accountId})) " +
            "AND (:#{#filter.latitude} IS NULL OR :#{#filter.longitude} IS NULL OR " +
            "(6371 * acos(cos(radians(:#{#filter.latitude})) * cos(radians(r.latitude)) * " +
            "cos(radians(r.longitude) - radians(:#{#filter.longitude})) + sin(radians(:#{#filter.latitude})) * " +
            "sin(radians(r.latitude)))) <= :#{#filter.distance}) " +
            "ORDER BY CASE " +
            "WHEN :#{#filter.sortBy} = 'LOCATION' THEN" +
            "(6371 * acos(cos(radians(:#{#filter.latitude})) * cos(radians(r.latitude)) * " +
            "cos(radians(r.longitude) - radians(:#{#filter.longitude})) + sin(radians(:#{#filter.latitude})) * " +
            "sin(radians(r.latitude)))) " +
            "WHEN :#{#filter.sortBy} = 'RATING' THEN " +
            "(SELECT COALESCE(AVG(rr.rating), 0) FROM RatingRestaurant rr WHERE rr.restaurant.id = r.id) " +
            "WHEN :#{#filter.sortBy} = 'REVIEWS' THEN " +
            "(SELECT COUNT(rr) FROM RatingRestaurant rr WHERE rr.restaurant.id = r.id) " +
            "END ")
    Page<Restaurant> findByFilterRequest(
            @Param("filter") RestaurantFilterRequest filterRequest,
            Pageable pageable);
}
