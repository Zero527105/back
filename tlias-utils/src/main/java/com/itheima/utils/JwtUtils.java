package com.itheima.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static final String secret_key = "aXroZWltYQ==";
    private static final long expiration_time = 12 * 60 * 60 * 1000;

    /**
     * 生成JWT令牌
     */
    public static String generateToken(Map<String, Object> claims){
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, secret_key)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expiration_time))
                .compact();
    }

    /**
     * 解析JWT令牌
     */
    public static Claims parseToken(String token) throws Exception{
        return Jwts.parser()
                .setSigningKey(secret_key)
                .parseClaimsJws(token)
                .getBody();
    }
}
