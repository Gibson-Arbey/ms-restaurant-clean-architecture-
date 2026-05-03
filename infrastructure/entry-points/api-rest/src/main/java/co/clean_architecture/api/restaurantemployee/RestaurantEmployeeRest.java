package co.clean_architecture.api.restaurantemployee;

import co.clean_architecture.api.config.SecurityUtil;
import co.clean_architecture.api.restaurantemployee.mapper.RegisterRestaurantEmployeeRequestMapper;
import co.clean_architecture.api.restaurantemployee.request.RegisterRestaurantEmployeeRequest;
import co.clean_architecture.usecase.restaurant.RegisterEmployeeRestaurantUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/restaurant-employee")
public class RestaurantEmployeeRest {

    private final RegisterEmployeeRestaurantUseCase registerEmployeeRestaurantUseCase;

    @PostMapping
    public ResponseEntity<Void> registerRestaurantEmployee(@RequestBody RegisterRestaurantEmployeeRequest request) {
        Long ownerId = SecurityUtil.getCurrentUserId();

        registerEmployeeRestaurantUseCase.execute(RegisterRestaurantEmployeeRequestMapper.toCommand(request), ownerId);
        return ResponseEntity.ok().build();
    }
}
