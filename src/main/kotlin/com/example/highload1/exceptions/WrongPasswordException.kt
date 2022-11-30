package com.example.highload1.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "А пароль то из говна.")
class WrongPasswordException : Exception()