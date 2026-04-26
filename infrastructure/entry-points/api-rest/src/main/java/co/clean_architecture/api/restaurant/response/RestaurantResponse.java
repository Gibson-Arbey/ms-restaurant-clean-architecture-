package co.clean_architecture.api.restaurant.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RestaurantResponse {
    private Long id;

    private String name;

    private String nit;

    private String address;

    private String phone;

    private String logoUrl;

    private Long ownerId;
}
