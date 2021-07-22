package com.example.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtils implements Serializable {

	private static final long serialVersionUID = 234234523523L;

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${jwt.secret}")
    private String secretKey;

    public String extractUserName(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	private Claims extractAllClaims(String token) {

		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}
	
	public Boolean isTokenExpired(String token) {
		//true if token expired
		return extractExpiration(token).before(new Date());
	}
	
	public String generateToken(String employeeMail) {
		
		Map<String, Object> claims = new HashMap<>();
		
		return createToken(claims, employeeMail);
	}
	
	//generate jwt token
	private String createToken(Map<String, Object> claims, String subject) {
		
		return Jwts.builder()
					.setClaims(claims)
					.setSubject(subject)
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis()  + 1000*60*60*10))
					.signWith(SignatureAlgorithm.HS256, secretKey).compact();
	}

	public boolean validateToken(String token, String employeeMail) {
		final String userName = extractUserName(token);
		return userName.equals(employeeMail) && !isTokenExpired(token);
	}
}
