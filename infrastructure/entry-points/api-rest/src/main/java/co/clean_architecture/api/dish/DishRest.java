package co.clean_architecture.api.dish;

import co.clean_architecture.api.config.SecurityUtil;
import co.clean_architecture.api.dish.mapper.DishResponseMapper;
import co.clean_architecture.api.dish.mapper.RegisterDishRequestMapper;
import co.clean_architecture.api.dish.request.RegisterDishRequest;
import co.clean_architecture.api.dish.response.DishResponse;
import co.clean_architecture.usecase.dish.RegisterDishUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dish")
public class DishRest {

    private final RegisterDishUseCase registerDishUseCase;

    @PostMapping
    public ResponseEntity<DishResponse> register(@RequestBody RegisterDishRequest request) {

        Long ownerId = SecurityUtil.getCurrentUserId();

        return ResponseEntity.status(HttpStatus.CREATED).body(
                DishResponseMapper.toResponse(
                        registerDishUseCase.execute(
                                RegisterDishRequestMapper.toCommand(request),
                                ownerId
                        )
                )
        );
    }
}
