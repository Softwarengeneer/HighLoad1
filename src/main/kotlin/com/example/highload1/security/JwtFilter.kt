package com.example.highload1.security

import com.example.highload1.persistance.User
import com.sun.istack.NotNull
import lombok.RequiredArgsConstructor
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@RequiredArgsConstructor
@Component
class JWTFilter : OncePerRequestFilter() {
    private val jwt: JWT? = null
    private val user: User? = null
    @Throws(ServletException::class, IOException::class)
    public override fun doFilterInternal(
        @NotNull request: HttpServletRequest,
        @NotNull response: HttpServletResponse,
        @NotNull filterChain: FilterChain
    ) {
        val optionalJwt = getTokenFromRequest(request)
        if (optionalJwt.isPresent && jwt!!.tokenIsValid(optionalJwt.get())) {
            val username = jwt.subjectFromToken(optionalJwt.get())
            val user: User =
                user?.findByName(username)?.orElseThrow { NullPointerException() } ?: throw RuntimeException("")
            //SecurityContextHolder.getContext().authentication =
                //UsernamePasswordAuthenticationToken(user, null, user.getAuthorities())
        }
        filterChain.doFilter(request, response)
    }

    private fun getTokenFromRequest(request: HttpServletRequest): Optional<String> {
        val bearer: String = request.getHeader("Authorization") ?: return Optional.empty()
        return if (bearer.startsWith("Bearer ")) Optional.of(bearer.substring(7)) else Optional.empty()
    }
}