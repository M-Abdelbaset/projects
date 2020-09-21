package com.home.jwt.util;

import java.util.Date;
import javax.crypto.SecretKey;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class JwtUtil {

	private static final String BASE64_SECRET;

	static {
		SecretKey key = MacProvider.generateKey(SignatureAlgorithm.HS256);
		BASE64_SECRET = TextCodec.BASE64.encode(key.getEncoded());
	}
	
	public static String createToken(String userName) {
		
		return Jwts.builder()
				.setSubject(userName)
				.setExpiration(new Date(new Date().getTime()+ 1000 * 60 * 5))
				.setIssuedAt(new Date())
				.setAudience("user")
				.claim("custom", "custom")
				.signWith(SignatureAlgorithm.HS256, BASE64_SECRET)
				.compact();
	}
	
	public static boolean isValidToken(String jwt) {
		
		try {
			Jwts.parser().setSigningKey(BASE64_SECRET).parseClaimsJws(jwt);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static String extractSubject(String jwt) {
		return Jwts.parser()
				.setSigningKey(BASE64_SECRET).parseClaimsJws(jwt).getBody().getSubject();
	}
	
	public static void main(String[] args) {
		String token = JwtUtil.createToken("user");
		System.out.println(JwtUtil.isValidToken(token));
	}
}
