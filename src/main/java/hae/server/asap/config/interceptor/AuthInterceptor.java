package hae.server.asap.config.interceptor;

import hae.server.asap.util.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {
    private final JwtService jwtService;

//
//    public boolean preHandle(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Object handler)throws Exception{
//
//        Optional<String> token = getToken(servletRequest);
//
//        if(token.isPresent()){
//
//        }
//    }

    private Optional<String> getToken(HttpServletRequest servletRequest) {

        String token = servletRequest.getHeader("Authorization");

        if(StringUtils.hasText(token))return Optional.of(token);
        else return Optional.empty();
    }
}
