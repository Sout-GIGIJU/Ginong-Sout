package kr.co.ginong.web.config.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

// 소셜 로그인 실패(= 신규 회원인 경우 )시, 회원가입 페이지로 redirect 하기 위한 FailureHandler
@Component
public class WebOAuth2FailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        // 회원가입 페이지로 리다이렉트
        getRedirectStrategy().sendRedirect(request, response, "/signup/social");
    }
}
