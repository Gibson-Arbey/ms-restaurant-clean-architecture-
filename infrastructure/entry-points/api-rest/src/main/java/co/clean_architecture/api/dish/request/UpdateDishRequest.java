package co.clean_architecture.api.dish.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateDishRequest {

    private Integer price;

    private String description;
}
