package co.clean_architecture.jpa.adapter;

import co.clean_architecture.jpa.mapper.RestaurantMapper;
import co.clean_architecture.jpa.repository.RestaurantJpaRepository;
import co.clean_architecture.model.restaurant.Restaurant;
import co.clean_architecture.model.restaurant.criteria.RestaurantCriteria;
import co.clean_architecture.model.restaurant.gateways.RestaurantRepository;
import co.clean_architecture.model.restaurant.projection.RestaurantSummaryProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public boolean existsByRestaurantIdAndOwnerId(Long id, Long ownerId) {
        return restaurantJpaRepository.existsByRestaurantIdAndOwnerId(id, ownerId);
    }

    @Override
    public boolean existsByRestaurantId(Long restaurantId) {
        return restaurantJpaRepository.existsById(restaurantId);
    }

    @Override
    public List<RestaurantSummaryProjection> findAllByCriteria(RestaurantCriteria criteria) {
        return restaurantJpaRepository.findAllByCriteria(
                criteria.getSearch(),
                criteria.getLimit(),
                criteria.getOffset()
        );
    }
}
