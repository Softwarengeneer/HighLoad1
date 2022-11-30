package com.example.highload1.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Э, долбаэб, ты уже зареган")
class ExistenceException : Exception()