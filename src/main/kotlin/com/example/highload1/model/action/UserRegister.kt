package com.example.highload1.model.action

import lombok.AllArgsConstructor
import lombok.Data
import lombok.Getter
import lombok.RequiredArgsConstructor
import java.util.*


@Getter
@Data
@AllArgsConstructor
@RequiredArgsConstructor
class UserRegister {
    private val name: String? = null
    private val phone: String? = null
    private val email: String? = null
    private val password: String? = null
}