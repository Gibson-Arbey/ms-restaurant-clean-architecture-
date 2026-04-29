package co.clean_architecture.usecase.dish;

import co.clean_architecture.model.dish.Dish;
import co.clean_architecture.model.dish.exception.DishNotFoundException;
import co.clean_architecture.model.dish.gateways.DishRepository;
import co.clean_architecture.usecase.dish.command.UpdateDishCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateDishUseCase {

    private final DishRepository dishRepository;

    public void execute(UpdateDishCommand command, Long id) {
        Dish dish = dishRepository.findById(id);
        if(dish == null) {
            throw new DishNotFoundException("Dish not found");
        }

        Dish updated = Dish.update(dish, command.price(), command.description());

        dishRepository.save(updated);
    }
}
