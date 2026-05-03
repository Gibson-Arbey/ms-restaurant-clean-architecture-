package co.clean_architecture.model.user.gateways;

public interface UserRepository {

    Boolean existsOwnerById(Long userId);

    Boolean existsEmployeeById(Long userId);
}
