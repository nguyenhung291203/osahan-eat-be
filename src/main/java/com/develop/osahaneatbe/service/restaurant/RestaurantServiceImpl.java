package com.develop.osahaneatbe.service.restaurant;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.develop.osahaneatbe.constant.error.RestaurantErrorCode;
import com.develop.osahaneatbe.constant.message.RestaurantErrorMessage;
import com.develop.osahaneatbe.dto.request.RestaurantCreationRequest;
import com.develop.osahaneatbe.dto.response.RestaurantResponse;
import com.develop.osahaneatbe.entity.Restaurant;
import com.develop.osahaneatbe.exception.ApiException;
import com.develop.osahaneatbe.exception.ValidateException;
import com.develop.osahaneatbe.mapper.RestaurantMapper;
import com.develop.osahaneatbe.repository.RestaurantRepository;
import com.develop.osahaneatbe.service.media.MediaService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RestaurantServiceImpl implements RestaurantService {
    RestaurantRepository restaurantRepository;
    RestaurantMapper restaurantMapper;
    MediaService mediaService;

    private Restaurant getRestaurantById(String id) {
        return restaurantRepository
                .findById(id)
                .orElseThrow(() -> new ApiException(RestaurantErrorCode.RESTAURANT_NOT_FOUND));
    }

    @Override
    public Map<String, String> createRestaurant(RestaurantCreationRequest request) {
        Map<String, String> errors = new HashMap<>();
        if (restaurantRepository.existsByTitle(request.getTitle())) {
            errors.put("title", RestaurantErrorMessage.TITLE_DUPLICATE);
        }
        if (restaurantRepository.existsByAddress(request.getAddress())) {
            errors.put("address", RestaurantErrorMessage.ADDRESS_DUPLICATE);
        }

        if (!errors.isEmpty()) {
            throw new ValidateException(errors);
        }

        Restaurant restaurant = restaurantMapper.toRestaurant(request);
        restaurantRepository.save(restaurant);

        return Map.of();
    }

    @Override
    public List<RestaurantResponse> findAllRestaurants() {
        return restaurantRepository.findAll().stream()
                .map(restaurantMapper::toRestaurantResponse)
                .toList();
    }

    @Override
    public RestaurantResponse findRestaurantById(String id) {
        Restaurant restaurant = getRestaurantById(id);
        return restaurantMapper.toRestaurantResponse(restaurant);
    }

    @Override
    @Transactional
    public Map<String, String> uploadImage(String id, MultipartFile file) throws IOException {
        Restaurant restaurant = getRestaurantById(id);
        String image = restaurant.getImage();
        if (image != null) {
            mediaService.deleteImage(image);
        }
        image = mediaService.uploadImage(file);
        restaurant.setImage(image);
        restaurantRepository.save(restaurant);
        return Map.of();
    }
}
