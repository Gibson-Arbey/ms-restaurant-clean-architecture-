package co.clean_architecture.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurants")
public class RestaurantEntity {

    @Id
    @Column(name = "rest_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rest_name", nullable = false)
    private String name;

    @Column(name = "rest_nit", nullable = false, unique = true)
    private String nit;

    @Column(name = "rest_address", nullable = false)
    private String address;

    @Column(name = "rest_phone", nullable = false)
    private String phone;

    @Column(name = "rest_logourl", nullable = false)
    private String logoUrl;

    @Column(name = "user_id", nullable = false)
    private Long ownerId;
}
