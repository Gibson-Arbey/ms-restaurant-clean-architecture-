package co.clean_architecture.jpa.adapter;

import co.clean_architecture.jpa.mapper.RestaurantEmployeeMapper;
import co.clean_architecture.jpa.repository.RestaurantEmployeeJpaRepository;
import co.clean_architecture.model.restaurantemployee.RestaurantEmployee;
import co.clean_architecture.model.restaurantemployee.gateways.RestaurantEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class RestaurantEmployeeAdapter implements RestaurantEmployeeRepository {

    private final RestaurantEmployeeJpaRepository restaurantEmployeeJpaRepository;
    @Override
    @Transactional
    public RestaurantEmployee save(RestaurantEmployee restaurantEmployee) {
        return RestaurantEmployeeMapper.toDomain(
            restaurantEmployeeJpaRepository
                .save(
                    RestaurantEmployeeMapper
                        .toEntity(restaurantEmployee))
        );
    }

    @Override
    public boolean existsByRestaurantIdAndEmployeeId(Long restaurantId, Long employeeId) {
        return restaurantEmployeeJpaRepository.existsByRestaurantIdAndEmployeeId(restaurantId, employeeId);
    }
}
