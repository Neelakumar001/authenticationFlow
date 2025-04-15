package com.example.AuthendicationFlow.util;


import com.example.AuthendicationFlow.Commen.error;
import com.example.AuthendicationFlow.Model.Register;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtToken {

    private static final String SECRET_KEY = "This_is_a_secure_256bit_secret_key!!!";
    private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));



    public String createToken(Register register) {
        long minutes=60*60;
        long date=System.currentTimeMillis();
        long expire = date + minutes*1000;
        Date createdate =new Date();
        Date expireTime =new Date(expire);

        return Jwts.builder().issuer(String.valueOf(register.getId())).signWith(key).issuedAt(createdate).expiration(expireTime).compact();

    }

    public Claims verifyToken(String token){
        return Jwts.parser().setSigningKey(key).build().parseSignedClaims(token).getBody();
    }
}
