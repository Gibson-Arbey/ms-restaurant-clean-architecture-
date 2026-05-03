package co.clean_architecture.jpa.adapter;

import co.clean_architecture.jpa.mapper.DishMapper;
import co.clean_architecture.jpa.repository.DishJpaRepository;
import co.clean_architecture.model.dish.Dish;
import co.clean_architecture.model.dish.criteria.DishCriteria;
import co.clean_architecture.model.dish.gateways.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DishAdapter implements DishRepository {

    private final DishJpaRepository dishJpaRepository;

    @Override
    @Transactional
    public Dish save(Dish dish) {
        return DishMapper.toDomain(dishJpaRepository.save(DishMapper.toEntity(dish)));
    }

    @Override
    public Dish findById(Long id) {
        return DishMapper.toDomain(dishJpaRepository.findById(id).orElse(null));
    }

    @Override
    public List<Dish> findAllByCriteria(DishCriteria criteria) {
        List<String> categories = criteria.getCategories()
                .stream()
                .map(Enum::name)
                .toList();
        return dishJpaRepository.findAllByCriteria(
                criteria.getRestaurantId(),
                categories,
                criteria.getLimit(),
                criteria.getOffset()
        ).stream().map(DishMapper::toDomain).toList();
    }
}
