package co.clean_architecture.jpa.repository;

import co.clean_architecture.jpa.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RestaurantJpaRepository extends JpaRepository<RestaurantEntity,Long> {

    @Query("""
        SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END
        FROM RestaurantEntity r
        WHERE r.id = :id AND r.ownerId = :ownerId
    """)
    boolean existsByIdAndOwnerId(@Param("id") Long id, @Param("ownerId") Long ownerId);
}
