package co.clean_architecture.api.dish;

import co.clean_architecture.api.config.SecurityUtil;
import co.clean_architecture.api.dish.mapper.DishResponseMapper;
import co.clean_architecture.api.dish.mapper.RegisterDishRequestMapper;
import co.clean_architecture.api.dish.mapper.UpdateDishRequestMapper;
import co.clean_architecture.api.dish.request.RegisterDishRequest;
import co.clean_architecture.api.dish.request.UpdateDishRequest;
import co.clean_architecture.api.dish.response.DishResponse;
import co.clean_architecture.usecase.dish.RegisterDishUseCase;
import co.clean_architecture.usecase.dish.UpdateDishUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dish")
public class DishRest {

    private final RegisterDishUseCase registerDishUseCase;
    private final UpdateDishUseCase updateDishUseCase;

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

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody UpdateDishRequest request) {
        updateDishUseCase.execute(UpdateDishRequestMapper.toCommand(request), id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
