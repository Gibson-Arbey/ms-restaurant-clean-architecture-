package co.clean_architecture.model.dish.gateways;

import co.clean_architecture.model.dish.Dish;
import co.clean_architecture.model.dish.criteria.DishCriteria;

import java.util.List;

public interface DishRepository {

    Dish save(Dish dish);

    Dish findById(Long id);

    List<Dish> findAllByCriteria(DishCriteria criteria);
}
