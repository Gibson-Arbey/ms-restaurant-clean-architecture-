package co.clean_architecture.model.restaurant.gateways;

import co.clean_architecture.model.restaurant.Restaurant;

public interface RestaurantRepository {

    Restaurant save(Restaurant restaurant);

    boolean existsByIdAndOwnerId(Long id, Long ownerId);
}
