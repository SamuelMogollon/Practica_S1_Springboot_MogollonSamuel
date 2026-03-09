package com.s1.gestion_producto.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service

public class JwtService {

    private final String SECRET = "clave_super_secreta_para_tarea_2026";

    private final long EXPIRATION = 1000 * 60 * 30;

    private Key getKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(String username) {
        return Jwts.builder()
                // Información principal del token (quién es el usuario)
                .setSubject(username)

                // Fecha en que se crea el token
                .setIssuedAt(new Date())

                // Fecha en que expira
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))

                // Firma con algoritmo HS256 usando mi clave secreta
                .signWith(getKey(), SignatureAlgorithm.HS256)

                // Construye el token final en formato String
                .compact();
    }

    public String validateToken(String token) {
        /*
         * Este método:
         * - Verifica que la firma sea correcta
         * - Verifica que no esté expirado
         * - Si todo está bien, devuelve el username
         *
         * Si algo falla, devuelve null.
         */
        try {
            return Jwts.parserBuilder()
                    // Le paso la misma clave con la que firmé
                    .setSigningKey(getKey())
                    .build()

                    // Intenta parsear el token
                    .parseClaimsJws(token)

                    // Obtengo el body (claims)
                    .getBody()

                    // Devuelvo el subject (username)
                    .getSubject();
        } catch (Exception e) {

            /*
             * Si el token:
             * - Está vencido
             * - Fue modificado
             * - La firma no coincide
             *
             * Lanza excepción y retorna en null.
             */

            return null;
        }
    }
}
