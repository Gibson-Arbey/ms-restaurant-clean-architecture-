package co.clean_architecture.jpa.repository;

import co.clean_architecture.jpa.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DishJpaRepository extends JpaRepository<DishEntity, Long> {

    @Query(value = """
        SELECT d.*
        FROM dishes d
        WHERE d.rest_id = :restaurantId
          AND (
                :#{#categories == null || #categories.isEmpty()} = true
                OR d.category IN (:categories)
              )
        ORDER BY d.dish_id
        LIMIT :limit OFFSET :offset
    """, nativeQuery = true)
    List<DishEntity> findAllByCriteria(
            @Param("restaurantId") Long restaurantId,
            @Param("categories") List<String> categories,
            @Param("limit") int limit,
            @Param("offset") int offset
    );
}
