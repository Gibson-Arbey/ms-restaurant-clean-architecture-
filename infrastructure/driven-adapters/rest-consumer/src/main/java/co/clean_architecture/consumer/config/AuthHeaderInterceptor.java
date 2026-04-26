package co.clean_architecture.consumer.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class AuthHeaderInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public org.springframework.http.client.ClientHttpResponse intercept(
            org.springframework.http.HttpRequest request,
            byte[] body,
            org.springframework.http.client.ClientHttpRequestExecution execution
    ) throws java.io.IOException {

        ServletRequestAttributes attrs =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (attrs != null) {
            String authHeader = attrs.getRequest().getHeader(HttpHeaders.AUTHORIZATION);

            if (authHeader != null && !authHeader.isBlank()) {
                request.getHeaders().add(HttpHeaders.AUTHORIZATION, authHeader);
            }
        }

        return execution.execute(request, body);
    }
}
