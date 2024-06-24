package com.group4.projectcodegeneration.security;

import com.group4.projectcodegeneration.model.User;
import com.group4.projectcodegeneration.service.EmailUserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.PublicKey;
import java.util.Date;

@Component
public class JwtProvider {

    @Value("${application.token.validity}")
    private long validityInMicroseconds;
    private final JwtKeyProvider keyProvider;
    private final EmailUserDetailsService userDetailsService;

    public JwtProvider(JwtKeyProvider keyProvider, EmailUserDetailsService userDetailsService) {
        this.keyProvider = keyProvider;
        this.userDetailsService = userDetailsService;
    }

    public String createToken(User user) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + validityInMicroseconds);

        return Jwts.builder()
                .subject(user.getEmail())
                .claim("auth", user.getRole())
                .issuedAt(now)
                .expiration(expiration)
                .signWith(keyProvider.getPrivateKey())
                .compact();
    }

    public Authentication getAuthentication(String token) {
        PublicKey publicKey = keyProvider.getPublicKey();
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(publicKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            String email = claims.getSubject();
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtException(e.getMessage());
        }
    }
}
