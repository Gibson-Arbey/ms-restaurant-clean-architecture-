package co.clean_architecture.jpa.mapper;

import co.clean_architecture.jpa.entity.DishEntity;
import co.clean_architecture.jpa.entity.RestaurantEntity;
import co.clean_architecture.model.dish.Dish;

public class DishMapper {


    public static Dish toDomain(DishEntity dishEntity) {
        if(dishEntity == null) return null;
        return Dish.restore(
                dishEntity.getId(),
                dishEntity.getName(),
                dishEntity.getPrice(),
                dishEntity.getDescription(),
                dishEntity.getImgUrl(),
                dishEntity.getCategory(),
                dishEntity.getRestaurant().getId(),
                dishEntity.getActive()
        );
    }

    public static DishEntity toEntity(Dish dish) {
        if(dish  == null) return null;
        return DishEntity.builder()
                .id(dish.getId())
                .name(dish.getName())
                .price(dish.getPrice())
                .description(dish.getDescription())
                .imgUrl(dish.getImgUrl())
                .category(dish.getCategory())
                .restaurant(RestaurantEntity.builder().id(dish.getRestaurantId()).build())
                .active(dish.getActive())
                .build();
    }
}
