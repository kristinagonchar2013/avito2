package com.amr.project.webapp.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ADMIN")) {
            httpServletResponse.sendRedirect("/admin");
        } else if(roles.contains("USER")){
            httpServletResponse.sendRedirect("/user");
        } else if (roles.contains("ANONYMOUS")) {
            httpServletResponse.sendRedirect("/anonymous");
        } else if (roles.contains("MODERATOR")) {
            httpServletResponse.sendRedirect("/moderator");
        }
    }
}
