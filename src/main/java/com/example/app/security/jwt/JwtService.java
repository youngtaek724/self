package com.example.app.security.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.app.security.dto.CustomUserDetails;
import com.example.app.security.dto.TokenData;
import com.example.app.security.enums.RoleType;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

  @Value("${auth.token.sign}")
  private String jwtSigningKey;

  public TokenData extractTokenData(String token) {
    Claims claims = extractAllClaims(token);
    TokenData tokenData = new TokenData(claims.getSubject(), RoleType.valueOf((String) claims.get("role")));

    return tokenData;
  } 

  public boolean isTokenValid(String token, String userDetails) {
    final TokenData tokenData = extractTokenData(token);
    final String id = tokenData.getId();
    return (id.equals(userDetails)) && !isTokenExpired(token);
  }

  private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
    final Claims claims = extractAllClaims(token);
    return claimsResolvers.apply(claims);
  }

  private String generateToken(Map<String, Object> extraClaims, UserDetails userDetails, Date time) {
    return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(time)
        .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
  }

  private boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  private Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }
 
  private Claims extractAllClaims(String token) {
    Claims cla = Jwts.parserBuilder()
    .setSigningKey(getSigningKey())
    .build()
    .parseClaimsJws(token)
    .getBody();
    return cla;
}

private SecretKey getSigningKey() {
  try {
      // 키를 Base64로 인코딩하여 바이트 배열로 변환
      byte[] encodedKeyBytes = Base64.getEncoder().encode(jwtSigningKey.getBytes());
      // HMAC-SHA 키 생성
      SecretKey secretKey = Keys.hmacShaKeyFor(encodedKeyBytes);

      return secretKey;
  } catch (Exception e) {
      throw new RuntimeException("Failed to generate HMAC-SHA key", e);
  }
}


  /**
   * Generate token
   * 
   * @param roleType
   * @param id
   * @return
   */
  public String generateToken(RoleType roleType, int id) {
    return generateToken(roleType, String.valueOf(id));
  }

  public String generateToken(RoleType roleType, String id) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("role", roleType);

    CustomUserDetails userDetails = new CustomUserDetails(id, id);
    userDetails.setRoleType(roleType);

    Date time = new Date();

    if (roleType.equals(RoleType.GUEST)) {
      time = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24); // 24시간
    }
    if (roleType.equals(RoleType.ADMIN) || roleType.equals(RoleType.USER)) {
      time = new Date(System.currentTimeMillis() + 6 * 60 * 60 * 1000); // 6시간
    }

    return generateToken(claims, userDetails, time);
  }
}
