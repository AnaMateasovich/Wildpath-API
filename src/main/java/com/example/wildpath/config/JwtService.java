package com.example.wildpath.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "549d8048e49287746fb0c77ad10cdb6b356375e542222346c79c7027f8a9f8e1";

    // Extrae el nombre de usuario (subject) desde el token.
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    //genera un token usando solo el nombre de usuario.
    public String generateToken(UserDetails userDetails) {
        String role = userDetails.getAuthorities().stream()
                .findFirst()
                .map(Object::toString)
                .orElse("ROLE_USER");

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", role);

        return generateToken(extraClaims, userDetails);
    }

    //permite incluir datos personalizados (claims) dentro del token
    public String generateToken (
            Map<String, Object> extractClaims,
            UserDetails userDetails
    ) {
        return Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername()) // el usuario al que pertenece el token
                .setIssuedAt(new Date(System.currentTimeMillis())) // cuando fue generado
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // cuando expira
                .signWith(SignatureAlgorithm.HS256, getSignInKey()) // firma el token con el algoritmo HMAC SHA-256 y la clave.
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    //Devuelve la fecha de expiración del token. true si vencio
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Métod genérico para extraer cualquier dato (claim) del token.
    public<T> T extractClaim(String token, Function<Claims, T> claimsTFunction) {
        final Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSignInKey())
                .parseClaimsJws(token)
                .getBody();
    }

    // Convierte la clave secreta en un objeto Key compatible con HMAC SHA-256, que se usa para firmar y verificar tokens.
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
