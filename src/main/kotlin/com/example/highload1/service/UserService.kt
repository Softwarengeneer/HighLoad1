package com.example.highload1.service

import com.example.highload1.exceptions.ExistenceException
import com.example.highload1.exceptions.WrongPasswordException
import com.example.highload1.model.action.UserLogin
import com.example.highload1.model.action.UserRegister
import com.example.highload1.persistance.User
import com.example.highload1.security.JWT
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service


@RequiredArgsConstructor
@Service
class UserService() {
    private val user: User? = null
    private val jwt: JWT? = null

    @Throws(ExistenceException::class)
    fun register(userRegister: UserRegister) {
        val name: String? = userRegister.getName()
        if (user?.findByName(name)?.orElse(null) != null) {
            throw ExistenceException()
        }
        val token: String? = generateToken(name)

    }

    @Throws(ExistenceException::class, WrongPasswordException::class)
    fun login(userLoginRq: UserLogin): String? {
        val user: User = user?.findByName(UserLogin.getName())?.orElse(null) ?: throw ExistenceException()
        if (!user.getPassword().equals(UserLogin.getPassword())) {
            throw WrongPasswordException()
        }
        val token: String? = generateToken(user.getName())
        user.setToken(token)
        user.save(user)
        return token
    }

    fun generateToken(name: String?): String? {
        return jwt?.generateToken(name)
    }
}