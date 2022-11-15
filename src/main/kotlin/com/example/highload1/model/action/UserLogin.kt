package com.example.highload1.model.action

import lombok.AllArgsConstructor
import lombok.Data


@Data
@AllArgsConstructor
class UserLogin {
    private val name: String? = null
    private val password: String? = null
}