package co.clean_architecture.jpa.adapter;

import co.clean_architecture.jpa.mapper.RestaurantMapper;
import co.clean_architecture.jpa.repository.RestaurantJpaRepository;
import co.clean_architecture.model.restaurant.Restaurant;
import co.clean_architecture.model.restaurant.gateways.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class RestaurantAdapter implements RestaurantRepository {

    private final RestaurantJpaRepository restaurantJpaRepository;

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        return RestaurantMapper
            .toDomain(
                restaurantJpaRepository
                    .save(
                        RestaurantMapper
                            .toEntity(restaurant)));
    }
}
