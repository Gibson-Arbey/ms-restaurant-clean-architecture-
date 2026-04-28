package co.clean_architecture.jpa.adapter;

import co.clean_architecture.jpa.mapper.DishMapper;
import co.clean_architecture.jpa.repository.DishJpaRepository;
import co.clean_architecture.model.dish.Dish;
import co.clean_architecture.model.dish.gateways.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class DishAdapter implements DishRepository {

    private final DishJpaRepository dishJpaRepository;

    @Override
    @Transactional
    public Dish create(Dish dish) {
        return DishMapper.toDomain(dishJpaRepository.save(DishMapper.toEntity(dish)));
    }
}
