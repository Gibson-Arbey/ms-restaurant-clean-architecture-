package co.clean_architecture.api.config;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityUtil {

    private SecurityUtil() {}

    public static Long getCurrentUserId() {
        Authentication authentication = getAuthentication();

        Object details = authentication.getDetails();

        if (details == null) {
            throw new AuthenticationCredentialsNotFoundException("User ID not found in security context");
        }

        if (!(details instanceof Long userId)) {
            throw new AuthenticationCredentialsNotFoundException("Invalid user ID type in security context");
        }

        return userId;
    }

    private static Authentication getAuthentication() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new AuthenticationCredentialsNotFoundException("No authenticated user found");
        }

        return authentication;
    }
}
