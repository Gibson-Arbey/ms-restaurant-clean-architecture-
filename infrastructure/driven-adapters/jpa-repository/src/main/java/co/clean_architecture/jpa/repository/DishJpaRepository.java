package co.clean_architecture.jpa.repository;

import co.clean_architecture.jpa.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishJpaRepository extends JpaRepository<DishEntity, Long> {
}
