package co.clean_architecture.model.restaurantemployee;

import co.clean_architecture.model.exception.InvalidFieldException;
import lombok.Getter;

@Getter
public class RestaurantEmployee {

    private Long id;

    private final Long restaurantId;

    private final Long employeeId;

    private RestaurantEmployee(Long id, Long restaurantId, Long employeeId) {
        if(restaurantId == null) {
            throw new InvalidFieldException("restaurantId cannot be null");
        }

        if(employeeId == null) {
            throw new InvalidFieldException("employeeId cannot be null");
        }

        this.id = id;
        this.restaurantId = restaurantId;
        this.employeeId = employeeId;
    }

    public static RestaurantEmployee create(Long restaurantId, Long employeeId) {
        return new RestaurantEmployee(null, restaurantId, employeeId);
    }

    public static RestaurantEmployee restore(Long id, Long restaurantId, Long employeeId) {
        return new RestaurantEmployee(id, restaurantId, employeeId);
    }
}
