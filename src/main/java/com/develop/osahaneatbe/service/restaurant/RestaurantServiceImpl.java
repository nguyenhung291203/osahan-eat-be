package com.develop.osahaneatbe.service.restaurant;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.transaction.Transactional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.develop.osahaneatbe.constant.error.AccountErrorCode;
import com.develop.osahaneatbe.constant.error.RestaurantErrorCode;
import com.develop.osahaneatbe.constant.key.CacheKey;
import com.develop.osahaneatbe.constant.message.RestaurantErrorMessage;
import com.develop.osahaneatbe.dto.request.RestaurantCreationRequest;
import com.develop.osahaneatbe.dto.request.RestaurantFilterRequest;
import com.develop.osahaneatbe.dto.response.PageResponse;
import com.develop.osahaneatbe.dto.response.RestaurantResponse;
import com.develop.osahaneatbe.entity.Account;
import com.develop.osahaneatbe.entity.FavoriteRestaurant;
import com.develop.osahaneatbe.entity.Restaurant;
import com.develop.osahaneatbe.exception.ApiException;
import com.develop.osahaneatbe.exception.ValidateException;
import com.develop.osahaneatbe.mapper.RestaurantMapper;
import com.develop.osahaneatbe.repository.AccountRepository;
import com.develop.osahaneatbe.repository.FavoriteRestaurantRepository;
import com.develop.osahaneatbe.repository.RestaurantRepository;
import com.develop.osahaneatbe.service.media.MediaService;
import com.develop.osahaneatbe.utils.ParamUtil;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RestaurantServiceImpl implements RestaurantService {
    RestaurantRepository restaurantRepository;
    RestaurantMapper restaurantMapper;
    AccountRepository accountRepository;
    MediaService mediaService;
    FavoriteRestaurantRepository favoriteRestaurantRepository;

    private Account getAccountById(String id) {
        return accountRepository.findById(id).orElseThrow(() -> new ApiException(AccountErrorCode.ACCOUNT_NOT_EXISTED));
    }

    private Restaurant getRestaurantById(String id) {
        return restaurantRepository
                .findById(id)
                .orElseThrow(() -> new ApiException(RestaurantErrorCode.RESTAURANT_NOT_FOUND));
    }

    private PageResponse<RestaurantResponse> convertToPageResponse(Page<Restaurant> restaurantPage) {
        return new PageResponse<>(
                restaurantPage.getContent().stream()
                        .map(restaurantMapper::toRestaurantResponse)
                        .toList(),
                restaurantPage.getTotalElements(),
                restaurantPage.getTotalPages());
    }

    @Override
    @CacheEvict(value = CacheKey.RESTAURANTS_CACHE, allEntries = true)
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
    @Cacheable(value = CacheKey.RESTAURANTS_CACHE)
    public List<RestaurantResponse> findAllRestaurants() {
        return restaurantRepository.findAll().stream()
                .map(restaurantMapper::toRestaurantResponse)
                .toList();
    }

    @Override
    @Cacheable(value = CacheKey.FAVORITE_CACHE, key = "#accountId")
    public List<RestaurantResponse> findFavorite(String accountId) {
        Account account = getAccountById(accountId);

        return account.getFavoriteRestaurants().stream()
                .map(favorite -> restaurantMapper.toRestaurantResponse(favorite.getRestaurant()))
                .toList();
    }

    @Override
    @CacheEvict(value = CacheKey.FAVORITE_CACHE, key = "#accountId")
    public Map<String, String> changeFavorite(String accountId, String restaurantId) {
        Account account = getAccountById(accountId);
        Restaurant restaurant = getRestaurantById(restaurantId);
        FavoriteRestaurant favorite = favoriteRestaurantRepository.findFavoriteRestaurantByAccountIdAndRestaurantId(
                account.getId(), restaurantId);
        if (favorite != null) {
            favoriteRestaurantRepository.delete(favorite);
            return Map.of();
        }
        FavoriteRestaurant favoriteRestaurant = FavoriteRestaurant.builder()
                .account(account)
                .restaurant(restaurant)
                .build();
        favoriteRestaurantRepository.save(favoriteRestaurant);
        return Map.of();
    }

    @Override
    @Cacheable(value = CacheKey.RESTAURANTS_CACHE, key = "#id")
    public RestaurantResponse findRestaurantById(String id) {
        Restaurant restaurant = getRestaurantById(id);
        return restaurantMapper.toRestaurantResponse(restaurant);
    }

    @Override
    @Transactional
    @CacheEvict(value = CacheKey.RESTAURANTS_CACHE, allEntries = true)
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

    @Override
    @Cacheable(value = CacheKey.RESTAURANTS_CACHE, key = "{#params, #request}")
    public PageResponse<RestaurantResponse> findRestaurantByFilter(
            Map<String, Object> params, RestaurantFilterRequest request) {
        Pageable pageable = ParamUtil.getPageable(params);
        Page<Restaurant> restaurantPage = restaurantRepository.findByFilterRequest(request, pageable);
        return convertToPageResponse(restaurantPage);
    }
}
