package co.clean_architecture.api.dish.mapper;

import co.clean_architecture.api.dish.response.DishResponse;
import co.clean_architecture.model.dish.Dish;

public class DishResponseMapper {

    public static DishResponse toResponse(Dish dish) {
        return DishResponse.builder()
                .id(dish.getId())
                .name(dish.getName())
                .description(dish.getDescription())
                .price(dish.getPrice())
                .category(dish.getCategory())
                .restaurantId(dish.getRestaurantId())
                .active(dish.getActive())
                .build();
    }
}
