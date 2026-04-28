package co.clean_architecture.usecase.dish.command;

import co.clean_architecture.model.dish.CategoryEnum;

public record RegisterDishCommand(String name, Integer price, String description, String imgUrl, CategoryEnum category, Long restaurantId) {
}
