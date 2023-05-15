package br.com.edusync.Spring.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class JwtService {

    private static final String SECRET_KEY = "fUjXn2r5u8x/A?D*G-KaPdSgVkYp3s6v";
    private Claims extractAllClaims(String token){

        return Jwt
                .parserBuilder()
                .setSigningKey(getSingnKey())
                .build()
                .parserClaimsJws(token)
                .getBody();

    }



    public String generateToken(
            UserDetails userDetails
    ){
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000 * 60 * 4))
                .compact();
    }

    private Key getSingnKey(){
        byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean isTokenValid(String token, UserDetails userDetails){

        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token){

        return extractClaim(token,Claims:: getExpiration);
    }
    public String extractUsername(String token){
        return extractClaim(token, Claims ::getSubject);

    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){

        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    }