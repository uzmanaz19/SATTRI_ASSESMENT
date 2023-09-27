package com.student.management.config;

import javax.crypto.SecretKey;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.util.*;

public class JwtUtils {
	private static final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	private static final long validityInMilliseconds = 3600000; // 1 hour

	public static String generateToken(String username, String role) {
		Date now = new Date();
		Date validity = new Date(now.getTime() + validityInMilliseconds);

		Map<String, Object> claims = new HashMap<>();
		claims.put("username", username);
		claims.put("role", role);

		return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validity).signWith(SignatureAlgorithm.HS256, secretKey).compact();
	}
	
    
	public static Claims parseToken(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}

}
