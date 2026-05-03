package co.clean_architecture.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurant_employee")
public class RestaurantEmployeeEntity {

    @Id
    @Column(name = "reem_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long employeeId;

    @Column(name = "rest_id", nullable = false)
    private Long restaurantId;
}
