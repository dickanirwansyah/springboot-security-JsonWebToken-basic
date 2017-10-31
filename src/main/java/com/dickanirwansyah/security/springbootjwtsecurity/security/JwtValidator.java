package com.dickanirwansyah.security.springbootjwtsecurity.security;

import com.dickanirwansyah.security.springbootjwtsecurity.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    private String secret = "youtube";

    public User validate(String token){

        User user = null;
        try{

            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            user = new User();
            user.setUsername(body.getSubject());
            user.setId(Long.parseLong((String)body.get("userId")));
            user.setRole((String)body.get("role"));

        }catch (Exception e){
            System.out.println(e);
        }
        return user;
    }
}
