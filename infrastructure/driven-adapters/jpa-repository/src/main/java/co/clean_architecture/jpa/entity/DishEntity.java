package co.clean_architecture.jpa.entity;

import co.clean_architecture.model.dish.CategoryEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dishes")
public class DishEntity {

    @Id
    @Column(name = "dish_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dish_name", nullable = false)
    private String name;

    @Column(name = "dish_price", nullable = false)
    private Integer price;

    @Column(name = "dish_description", nullable = false)
    private String description;

    @Column(name = "dish_imgurl", nullable = false)
    private String imgUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "dish_category", nullable = false)
    private CategoryEnum category;

    @Column(name = "dish_active", nullable = false)
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "rest_id",  nullable = false)
    private RestaurantEntity restaurant;

}
