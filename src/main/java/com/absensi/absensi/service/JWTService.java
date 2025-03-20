package com.absensi.absensi.service;

import java.security.Key;
import java.sql.Date;
import java.util.HashMap;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.absensi.absensi.model.UserModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
   @Value("${security.jwt.secret-key}")
   private String secretKey;

   @Value("${security.jwt.expiration-time}")
   private long jwtExpiration;

   public String generateToken(UserModel userModel) {
      return generateToken(new HashMap<>(), userModel);
   }

   public String generateToken(HashMap<String, Object> extraClaims, UserModel userModel) {
      return Jwts.builder()
            .setClaims(extraClaims)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
            .setSubject(userModel.getNik())
            .signWith(getSignInKey(), SignatureAlgorithm.HS256)
            .compact();
   }

   public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
      final Claims claims = extractAllClaims(token);
      return claimsResolver.apply(claims);
   }

   private Claims extractAllClaims(String token) {
      return Jwts
            .parserBuilder()
            .setSigningKey(getSignInKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
   }

   private Key getSignInKey() {
      byte[] keyBytes = Decoders.BASE64.decode(secretKey);
      return Keys.hmacShaKeyFor(keyBytes);
   }
}
