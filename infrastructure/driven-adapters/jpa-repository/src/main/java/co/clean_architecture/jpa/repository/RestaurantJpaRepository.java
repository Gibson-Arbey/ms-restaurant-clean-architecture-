package co.clean_architecture.jpa.repository;

import co.clean_architecture.jpa.entity.RestaurantEntity;
import co.clean_architecture.model.restaurant.criteria.RestaurantCriteria;
import co.clean_architecture.model.restaurant.projection.RestaurantSummaryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantJpaRepository extends JpaRepository<RestaurantEntity,Long> {

    @Query("""
        SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END
        FROM RestaurantEntity r
        WHERE r.id = :restaurantId AND r.ownerId = :ownerId
    """)
    boolean existsByRestaurantIdAndOwnerId(@Param("restaurantId") Long restaurantId, @Param("ownerId") Long ownerId);

    @Query(value = """
        SELECT r.rest_id AS id,
               r.rest_name AS name,
               r.rest_logourl AS logoUrl
        FROM restaurants r
        WHERE (:search = '' OR LOWER(r.rest_name) LIKE LOWER(CONCAT('%', :search, '%')))
        LIMIT :limit OFFSET :offset
    """, nativeQuery = true)
    List<RestaurantSummaryProjection> findAllByCriteria(
            @Param("search") String search,
            @Param("limit") int limit,
            @Param("offset") int offset
    );
}
