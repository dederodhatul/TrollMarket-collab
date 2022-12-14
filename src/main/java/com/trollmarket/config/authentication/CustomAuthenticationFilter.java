package com.trollmarket.config.authentication;

import com.trollmarket.exceptionhandler.RoleAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authRequest = getAuth(request);
        if(!authRequest.getAuthorities().equals(request.getParameter("role"))){
            throw new RoleAuthenticationException("the Selected Role Didnt Match to Account Role");
        }
        setDetails(request,authRequest);

        return getAuthenticationManager().authenticate(authRequest);
    }
    private UsernamePasswordAuthenticationToken getAuth(final HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        return new UsernamePasswordAuthenticationToken(
                username, password);
    }
}
