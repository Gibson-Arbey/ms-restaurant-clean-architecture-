package co.clean_architecture.security.util;

import co.clean_architecture.security.config.SecurityConstantsConfig;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final SecurityConstantsConfig securityConstants;


    public DecodedJWT validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(securityConstants.getJwtKeyPrivate());
        return JWT.require(algorithm)
                .withIssuer(securityConstants.getJwtUserGenerator())
                .build()
                .verify(token);
    }

    public Long extractUserId(DecodedJWT jwt) {
        return jwt.getClaim("userId").asLong();
    }

    public String extractRole(DecodedJWT jwt) {
        return jwt.getClaim("role").asString();
    }

    public String extractUsername(DecodedJWT jwt) {
        return jwt.getClaim("username").asString();
    }
}
