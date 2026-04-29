package co.clean_architecture.model.dish;

import co.clean_architecture.model.exception.InvalidFieldException;
import lombok.Getter;

@Getter
public class Dish {

    private Long id;

    private final String name;

    private final Integer price;

    private final String description;

    private final String imgUrl;

    private final CategoryEnum category;

    private final Long restaurantId;

    private final Boolean active;

    private Dish(Long id, String name, Integer price, String description, String imgUrl, CategoryEnum category, Long restaurantId, Boolean active) {
        if(name== null || name.isBlank()) {
            throw new InvalidFieldException("Name is required");
        }
        if(price == null || price <= 0) {
            throw new InvalidFieldException("Price must be greater than 0");
        }
        if(description == null || description.isBlank()) {
            throw new InvalidFieldException("Description is required");
        }
        if(imgUrl == null || imgUrl.isBlank()) {
            throw new InvalidFieldException("ImgUrl is required");
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imgUrl = imgUrl;
        this.category = category;
        this.restaurantId = restaurantId;
        this.active = active;
    }

    public static Dish create(String name, Integer price, String description, String imgUrl, CategoryEnum category, Long restaurantId) {
        return new Dish(null, name, price, description, imgUrl, category, restaurantId, true);
    }

    public static Dish restore(Long id, String name, Integer price, String description, String imgUrl, CategoryEnum category, Long restaurantId, Boolean active) {
        return new Dish(id, name, price, description, imgUrl, category, restaurantId, active);
    }

    public static Dish update(Dish current, Integer newPrice, String newDescription) {
        if (current == null) {
            throw new InvalidFieldException("Dish cannot be null");
        }

        return new Dish(current.getId(), current.getName(), newPrice, newDescription,
                current.getImgUrl(), current.getCategory(), current.getRestaurantId(), current.getActive()
        );
    }
}
