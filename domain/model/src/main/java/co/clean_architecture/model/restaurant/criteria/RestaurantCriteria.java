package co.clean_architecture.model.restaurant.criteria;

import lombok.Getter;

@Getter
public class RestaurantCriteria {

    private final String search;

    private final int limit;

    private final int offset;

    private RestaurantCriteria(String search, Integer limit, Integer offset) {
        this.search = search != null ? search : "";
        this.limit = limit == null ? 10 : limit;
        this.offset = offset == null ? 0 : offset;
    }

    public static RestaurantCriteria of(String search, Integer limit, Integer offset) {
        return new RestaurantCriteria(search, limit, offset);
    }
}
