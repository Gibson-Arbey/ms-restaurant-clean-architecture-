package co.clean_architecture.consumer.user;

import co.clean_architecture.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserConsumer implements UserRepository {

    private final RestClient userRestClient;

    @Override
    public Boolean existsOwnerById(Long userId) {
        try {
            Boolean response = userRestClient.get()
                    .uri("/api/v1/user/{userId}/exists-owner", userId)
                    .retrieve()
                    .body(Boolean.class);

            return Boolean.TRUE.equals(response);
        } catch (Exception e) {
            log.error("Error consuming user service: {}", e.getMessage());
            return false;
        }
    }
}
