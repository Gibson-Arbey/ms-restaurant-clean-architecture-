package co.clean_architecture.usecase.restaurant;

import co.clean_architecture.model.restaurant.criteria.RestaurantCriteria;
import co.clean_architecture.model.restaurant.gateways.RestaurantRepository;
import co.clean_architecture.model.restaurant.projection.RestaurantSummaryProjection;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListRestaurantsUseCase {

    private final RestaurantRepository restaurantRepository;

    public List<RestaurantSummaryProjection> execute(RestaurantCriteria criteria) {
        return restaurantRepository.findAllByCriteria(criteria);
    }
}
