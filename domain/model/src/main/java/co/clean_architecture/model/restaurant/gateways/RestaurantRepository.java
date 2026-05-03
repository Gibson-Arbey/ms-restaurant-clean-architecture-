package co.clean_architecture.model.restaurant.gateways;

import co.clean_architecture.model.restaurant.Restaurant;
import co.clean_architecture.model.restaurant.criteria.RestaurantCriteria;
import co.clean_architecture.model.restaurant.projection.RestaurantSummaryProjection;

import java.util.List;

public interface RestaurantRepository {

    Restaurant save(Restaurant restaurant);

    boolean existsByRestaurantIdAndOwnerId(Long restaurantId, Long ownerId);

    boolean existsByRestaurantId(Long restaurantId);

    List<RestaurantSummaryProjection> findAllByCriteria(RestaurantCriteria criteria);
}
