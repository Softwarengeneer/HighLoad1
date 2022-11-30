package com.example.highload1.service

import com.example.highload1.exceptions.ExistenceException
import com.example.highload1.exceptions.WrongPasswordException
import com.example.highload1.model.action.UserLogin
import com.example.highload1.model.action.UserRegister
import com.example.highload1.model.entities.User
import com.example.highload1.persistance.UserRepository
import com.example.highload1.security.JWT
import org.springframework.stereotype.Service


@Service
class UserService() {
    private val userRepository: UserRepository? = null
    private val jwt: JWT? = null

    @Throws(ExistenceException::class)
    fun register(userRegister: UserRegister?): String? {
        val name: String? = userRegister?.name
        if (userRepository?.findByName(name)?.orElse(null) != null) {
            throw ExistenceException()
        }
        val token: String? = generateToken(name)
        return token
    }

    @Throws(ExistenceException::class, WrongPasswordException::class)
    fun login(userLoginRq: UserLogin?): String? {
        val user: User = userRepository?.findByName(userLoginRq?.name)?.orElse(null) ?: throw ExistenceException()
        if (userLoginRq != null) {
            if (!user.getPassword().equals(userLoginRq.password)) {
                throw WrongPasswordException()
            }
        }
        userRepository.save(user)
        val token: String? = generateToken(user.username)
//        userRepository.setToken(token)
        return token
    }

    fun generateToken(name: String?): String? {
        return jwt?.generateToken(name)
    }
}