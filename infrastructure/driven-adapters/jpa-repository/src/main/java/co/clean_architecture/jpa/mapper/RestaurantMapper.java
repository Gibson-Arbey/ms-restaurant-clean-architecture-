package co.clean_architecture.jpa.mapper;

import co.clean_architecture.jpa.entity.RestaurantEntity;
import co.clean_architecture.model.restaurant.Restaurant;

public class RestaurantMapper {

    public static Restaurant toDomain(RestaurantEntity restaurantEntity) {
        return Restaurant.restore(
                restaurantEntity.getId(),
                restaurantEntity.getName(),
                restaurantEntity.getNit(),
                restaurantEntity.getAddress(),
                restaurantEntity.getPhone(),
                restaurantEntity.getLogoUrl(),
                restaurantEntity.getOwnerId()
        );
    }

    public static RestaurantEntity toEntity(Restaurant restaurant) {
        return RestaurantEntity.builder()
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
