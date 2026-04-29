package co.clean_architecture.model.dish.gateways;

import co.clean_architecture.model.dish.Dish;

public interface DishRepository {

    Dish save(Dish dish);

    Dish findById(Long id);
}
