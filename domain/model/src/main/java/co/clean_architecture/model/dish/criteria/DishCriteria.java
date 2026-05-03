package co.clean_architecture.model.dish.criteria;

import co.clean_architecture.model.dish.CategoryEnum;
import lombok.Getter;

import java.util.List;

@Getter
public class DishCriteria {

    private final Long restaurantId;

    private final List<CategoryEnum> categories;

    private final int limit;

    private final int offset;

    private DishCriteria(Long restaurantId,  List<CategoryEnum> categories, Integer limit, Integer offset) {
        this.restaurantId = restaurantId != null ? restaurantId : 0L;
        this.categories = categories != null ? categories : List.of();
        this.limit = limit != null ? limit : 10;
        this.offset = offset != null ? offset : 0;
    }

    public static DishCriteria of(Long restaurantId, List<CategoryEnum> categories, Integer limit, Integer offset) {
        return new DishCriteria(restaurantId, categories, limit, offset);
    }
}
