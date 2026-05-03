package co.clean_architecture.usecase.restaurant.command;

public record RegisterRestaurantEmployeeCommand(Long restaurantId, Long employeeId) {
}
