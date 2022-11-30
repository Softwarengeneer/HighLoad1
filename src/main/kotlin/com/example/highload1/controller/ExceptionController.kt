package com.example.highload1.controller

import com.example.highload1.exceptions.ExistenceException
import com.example.highload1.exceptions.WrongPasswordException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(NullPointerException::class)
    fun handleNPE(e: NullPointerException?): String {
        return "Бля поинтер в жопе"
    }

    @ExceptionHandler(ExistenceException::class)
    fun handleUserAlreadyExistException(e: ExistenceException?): String? {
        return "Э, долбаэб, ты уже зареган"
    }
    @ExceptionHandler(WrongPasswordException::class)
    fun handleWrongPasswordException(e: WrongPasswordException?): String {
        return "А пароль то из говна."
    }

}