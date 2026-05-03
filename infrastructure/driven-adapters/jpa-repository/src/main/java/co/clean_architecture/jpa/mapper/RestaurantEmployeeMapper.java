package co.clean_architecture.jpa.mapper;

import co.clean_architecture.jpa.entity.RestaurantEmployeeEntity;
import co.clean_architecture.model.restaurantemployee.RestaurantEmployee;

public class RestaurantEmployeeMapper {

    public static RestaurantEmployee toDomain(RestaurantEmployeeEntity restaurantEmployeeEntity) {
        if (restaurantEmployeeEntity == null) {
            return null;
        }
        return RestaurantEmployee.restore(
                restaurantEmployeeEntity.getId(),
                restaurantEmployeeEntity.getRestaurantId(),
                restaurantEmployeeEntity.getEmployeeId()
        );
    }

    public static RestaurantEmployeeEntity toEntity(RestaurantEmployee restaurantEmployee) {
        if (restaurantEmployee == null) {
            return null;
        }
        return RestaurantEmployeeEntity.builder()
                .id(restaurantEmployee.getId())
                .restaurantId(restaurantEmployee.getRestaurantId())
                .employeeId(restaurantEmployee.getEmployeeId())
                .build();
    }
}
