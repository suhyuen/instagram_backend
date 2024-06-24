package com.example.instagram.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyStore;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.signing.key}")
    private String signingKey;

    public String createToken(int userUid, String role, Long expirationMs){
        SecretKey key = Keys.hmacShaKeyFor((signingKey.getBytes(StandardCharsets.UTF_8)));
        return Jwts.builder()
                .claim("userUid", userUid)
                .claim("role", role)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+expirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // token에서 role 꺼내오기
    public String getRole(String token){
        SecretKey key = Keys.hmacShaKeyFor(signingKey.getBytes(StandardCharsets.UTF_8));
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token.substring("Bearer ".length()))
                .getBody()
                .get("role", String.class);

    }

    //token에서 userUid 가지고 오기
    public int getUserUid (String token){
        SecretKey key = Keys.hmacShaKeyFor(signingKey.getBytes(StandardCharsets.UTF_8));
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token.substring("Bearer ".length()))
                .getBody()
                .get("userUid", Integer.class);
    }

    public boolean isExpired(String token){
        SecretKey key = Keys.hmacShaKeyFor(signingKey.getBytes(StandardCharsets.UTF_8));
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token.substring("Bearer ".length()))
                .getBody()
                .getExpiration()
                .before(new Date());
    }
}
