package co.clean_architecture.jpa.repository;

import co.clean_architecture.jpa.entity.RestaurantEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RestaurantEmployeeJpaRepository extends JpaRepository<RestaurantEmployeeEntity, Long> {

    @Query("""
        SELECT CASE WHEN COUNT(re) > 0 THEN true ELSE false END
        FROM RestaurantEmployeeEntity re
        WHERE re.restaurantId = :restaurantId AND re.employeeId = :employeeId
    """)
    boolean existsByRestaurantIdAndEmployeeId(
        @Param("restauranId") Long restaurantId,
        @Param("employeeId") Long employeeId);
}
