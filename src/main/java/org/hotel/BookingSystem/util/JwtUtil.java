//package org.hotel.BookingSystem.util;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
//import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
//import org.springframework.stereotype.Component;
//
//import java.security.Signature;
//import java.util.Date;
//import java.util.stream.DoubleStream;
//
//@Component
//public class JwtUtil {
//    private final String SECRET = "my_secret_key";
//
//    public String generateToken(String email){
//        return Jwts.builder()
//                .setSubject(email)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
//                .signWith(SignatureAlgorithm.HS256, SECRET)
//                .compact();
//    }
//
//   private String extractEmail(String token) {
//    return Jwts.parser().setSigningKey(SECRET)
//            .parseClaimsJws(token).getBody().getSubject();
//   }
//
//   private boolean validateToken(String token, String email) {
//        return extractEmail(token).equals(email);
//   }
//}
