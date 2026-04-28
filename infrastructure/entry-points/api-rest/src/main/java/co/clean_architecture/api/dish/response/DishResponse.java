package co.clean_architecture.api.dish.response;

import co.clean_architecture.model.dish.CategoryEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DishResponse {

    private Long id;

    private String name;

    private Integer price;

    private String description;

    private String imgUrl;

    private CategoryEnum category;

    private Long restaurantId;

    private Boolean active;
}
