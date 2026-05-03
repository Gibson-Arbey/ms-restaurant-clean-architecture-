package co.clean_architecture.model.restaurantemployee.gateways;

import co.clean_architecture.model.restaurantemployee.RestaurantEmployee;

public interface RestaurantEmployeeRepository {

    RestaurantEmployee save(RestaurantEmployee restaurantEmployee);

    boolean existsByRestaurantIdAndEmployeeId(Long restaurantId, Long employeeId);
}
