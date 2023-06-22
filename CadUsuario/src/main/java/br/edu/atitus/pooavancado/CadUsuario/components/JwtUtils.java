package br.edu.atitus.pooavancado.CadUsuario.components;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtUtils {
	
	private final String jwtSecret = "=====================AtitusSecretJWT=====================";
	private final int jwtExpirationMs = 86400000;
	
	public String getEmailFromJwtToken(String token) {
		return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody().getSubject();
	}
	
	public String getJwtFromRequest(HttpServletRequest request) {
		String jwt = request.getHeader("Authorization");
		if (jwt != null && !jwt.isEmpty()) {
			return jwt.substring(7);
		}
		return null;
	}
	
	public boolean validaJwtToken(String jwt) {
		try {
			Jwts.parserBuilder().setSigningKey(key()).build().parse(jwt);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	public String generateTokenFromEmail(String email) throws InvalidKeyException {
		return Jwts.builder()
				.setSubject(email)
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(key(), SignatureAlgorithm.HS256)
				.compact();
	}
	
	private Key key() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	}
	
	

}
