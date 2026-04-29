package co.clean_architecture.api.dish.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDishRequest {

    private String name;

    private Integer price;

    private String description;

    private String imgUrl;

    private String category;

    private Long restaurantId;
}
