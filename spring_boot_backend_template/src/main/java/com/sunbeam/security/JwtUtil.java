package com.sunbeam.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
 
	private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	private final long JWT_EXPIRATION = 1000 * 60 * 60;
	
	private String createToken(Map<String,Object> claims,String subject) {
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+JWT_EXPIRATION))
				.signWith(key)
				.compact();
	}
	
	public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (username.equals(extractedUsername) && !isTokenExpired(token));
    }
	
	public String generateToken(String username,String role) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("role", role);
		return createToken(claims,username);
	}
	
	
	 public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }

	    public String extractRole(String token) {
	        return extractAllClaims(token).get("role", String.class);
	    }

	    private boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }

	    private Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }

	    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }

	    private Claims extractAllClaims(String token) {
	        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	    }
	
}
