package codes.rytis.logindemo.service;

import codes.rytis.logindemo.dto.token.TokenDto;
import codes.rytis.logindemo.security.JwtIssuer;
import codes.rytis.logindemo.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;

    public TokenDto attemptLogin(String email, String password) {
        System.out.println("11");
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        System.out.println("21");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("31");
        var principal = (UserPrincipal) authentication.getPrincipal();
        System.out.println("41");
        var token = jwtIssuer.issue(JwtIssuer.Request.builder()
                .userId(principal.getUserId())
                .email(principal.getEmail())
                .roles(principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                .build());
        System.out.println("TOKEN:" + token);
        return TokenDto.builder()
                .token(token)
                .build();
    }
}
