package com.parkerneff.oidc;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider
        implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        if ("myadmin".equals(name) && "password".equals("password")) {
            grantedAuthorities.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "ROLE_ADMIN";
                }
            });
            return new UsernamePasswordAuthenticationToken(
                    name, password, grantedAuthorities);

        } else  if ("myuser".equals(name) && "password".equals("password")) {
            grantedAuthorities.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "ROLE_USER";
                }
            });
            return new UsernamePasswordAuthenticationToken(
                    name, password, grantedAuthorities);

        } else {
            return null;
        }




    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}
