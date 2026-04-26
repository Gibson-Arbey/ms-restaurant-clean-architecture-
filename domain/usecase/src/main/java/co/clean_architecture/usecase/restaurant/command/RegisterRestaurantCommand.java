package co.clean_architecture.usecase.restaurant.command;

public record RegisterRestaurantCommand(String name, String nit, String address, String phone, String logoUrl, Long ownerId) {
}
