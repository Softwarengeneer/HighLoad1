package com.example.highload1.controller

import com.example.highload1.model.action.UserLogin
import com.example.highload1.model.action.UserRegister
import com.example.highload1.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user")
class UserController {
    private val userService: UserService? = null

    @PostMapping("/sign-up")
    fun signUp(@RequestBody userRegister: UserRegister?): ResponseEntity<String?> {
        val token: String? = userService?.register(userRegister)
        return ResponseEntity.ok(token)
    }


    @PostMapping("/sign-in")
    fun signIn(@RequestBody userLogin: UserLogin?): ResponseEntity<String?>? {
        val token: String? = userService?.login(userLogin)
        return ResponseEntity.ok(token)
    }


}

