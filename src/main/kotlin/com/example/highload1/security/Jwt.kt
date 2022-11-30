package com.example.highload1.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*


@Service
class JWT{
    @Value("\${jwt.secret}")
    private val jwtSecret: String? = null
    fun generateToken(username: String?): String {
        val now = Date()
        val exp = Date.from(LocalDateTime.now().plusDays(7).atZone(ZoneId.systemDefault()).toInstant())
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(now)
            .setNotBefore(now)
            .setExpiration(exp)
            .signWith(SignatureAlgorithm.HS256, jwtSecret)
            .compact()
    }

    fun tokenIsValid(token: String?): Boolean {
        return try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun subjectFromToken(token: String?): String {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).body.subject
    }
}