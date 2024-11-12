package com.develop.osahaneatbe.service.dish;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.develop.osahaneatbe.dto.request.DishCreationRequest;
import com.develop.osahaneatbe.dto.response.DishCompact;
import com.develop.osahaneatbe.dto.response.DishResponse;
import com.develop.osahaneatbe.dto.response.DishRestaurantResponse;

public interface DishService {
    Map<String, String> createDish(DishCreationRequest request);

    List<DishResponse> findAllDishes();

    DishResponse findDishById(String id);

    Map<String, String> uploadImage(String id, MultipartFile file) throws IOException;

    List<DishCompact> findAllDishesByRestaurantId(String restaurantId);

    DishRestaurantResponse findDishByIdAndRestaurantId(String id, String restaurantId);
}
