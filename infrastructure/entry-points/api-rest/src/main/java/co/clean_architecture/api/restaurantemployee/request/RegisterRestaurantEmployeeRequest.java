package co.clean_architecture.api.restaurantemployee.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRestaurantEmployeeRequest {

    private Long restaurantId;

    private Long employeeId;
}
