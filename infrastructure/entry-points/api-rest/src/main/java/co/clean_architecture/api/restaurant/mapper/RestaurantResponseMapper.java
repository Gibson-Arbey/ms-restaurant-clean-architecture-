package co.clean_architecture.api.restaurant.mapper;

import co.clean_architecture.api.restaurant.response.RestaurantResponse;
import co.clean_architecture.model.restaurant.Restaurant;

public class RestaurantResponseMapper {

    public static RestaurantResponse toResponse(Restaurant restaurant) {
        return RestaurantResponse.builder()
            .id(restaurant.getId())
            .name(restaurant.getName())
            .nit(restaurant.getNit())
            .address(restaurant.getAddress())
            .phone(restaurant.getPhone())
            .logoUrl(restaurant.getLogoUrl())
            .ownerId(restaurant.getOwnerId())
            .build();
    }
}
