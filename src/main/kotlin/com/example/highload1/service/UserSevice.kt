package com.example.highload1.service

import com.example.highload1.exceptions.ExistenceException
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.highload1.model.action.UserRegister;


@RequiredArgsConstructor
@Service
class UserSevice {

    @Throws(ExistenceException::class)
    fun register(userRegister: UserRegister) {
//        val name: String = userRegister.getName()

    }
}