package com.projects.personal_blog;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String jwtAccessSecret;

    @Value("${jwt.expiration}")
    private long accessTokenValidity;

    public String GenerateAccessToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())  // кто вошёл (уникальный логин)
                .claim("authorities", userDetails.getAuthorities())  // права пользователя
                .setIssuedAt(new Date())  // когда выпущен токен
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenValidity))  // когда закончится
                .signWith(SignatureAlgorithm.HS256, jwtAccessSecret)  // подпись токена (ключ + алгоритм)
                .compact();  // собрать всё в строку
    }

    public String getUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtAccessSecret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public Collection<SimpleGrantedAuthority> getAuthorities(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtAccessSecret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();

        List<?> roles = claims.get("authorities", List.class);

        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.toString()))
                .collect(Collectors.toList());
    }

    public boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtAccessSecret.getBytes())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
