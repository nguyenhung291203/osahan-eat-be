package com.develop.osahaneatbe.service.restaurant;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.develop.osahaneatbe.dto.request.RestaurantCreationRequest;
import com.develop.osahaneatbe.dto.response.RestaurantResponse;

public interface RestaurantService {
    Map<String, String> createRestaurant(RestaurantCreationRequest request);

    List<RestaurantResponse> findAllRestaurants();

    RestaurantResponse findRestaurantById(String id);

    Map<String, String> uploadImage(String id, MultipartFile file) throws IOException;
}
