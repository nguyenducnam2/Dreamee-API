package org.dreameeapi.config.security.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dreameeapi.entity.User;
import org.dreameeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UsernamePasswordProcessLoginFilter implements Filter {
    @Autowired
    private UserService userService;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && password != null) {
            User user = userService.findByUsername(username).get(0);
            Cookie cookie = new Cookie("uId", user.getId() + "");
            response.addCookie(cookie);
            user.setPassword(password);
            request.getSession().setAttribute("user", user);
        }
        chain.doFilter(req, res);
    }
}
