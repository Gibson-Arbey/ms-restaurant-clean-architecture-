package co.clean_architecture.jpa.repository;

import co.clean_architecture.jpa.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantJpaRepository extends JpaRepository<RestaurantEntity,Long> {
}
