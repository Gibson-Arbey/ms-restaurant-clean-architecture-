package co.clean_architecture.api.restaurant;

import co.clean_architecture.api.restaurant.mapper.RegisterRestaurantRequestMapper;
import co.clean_architecture.api.restaurant.mapper.RestaurantResponseMapper;
import co.clean_architecture.api.restaurant.request.RegisterRestaurantRequest;
import co.clean_architecture.api.restaurant.response.RestaurantResponse;
import co.clean_architecture.usecase.restaurant.RegisterRestaurantUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurant")
public class RestaurantRest {

    private final RegisterRestaurantUseCase registerRestaurantUseCase;

    @PostMapping
    public ResponseEntity<RestaurantResponse> registerRestaurant(@RequestBody RegisterRestaurantRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                RestaurantResponseMapper.toResponse(
                        registerRestaurantUseCase.execute(
                                RegisterRestaurantRequestMapper.toCommand(request)
                        )
                )
        );
    }
}
