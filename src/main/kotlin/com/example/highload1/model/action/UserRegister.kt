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
    fun getName(): String? {
        return this.name
    }

    @Getter
    private val name: String? = null
    @Getter
    private val phone: String? = null
    @Getter
    private val email: String? = null
    @Getter
    private val password: String? = null
}