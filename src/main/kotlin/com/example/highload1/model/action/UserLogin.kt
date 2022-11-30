package com.example.highload1.model.action

import lombok.AllArgsConstructor
import lombok.Data
import lombok.Getter


@Data
@AllArgsConstructor
class UserLogin {
    @Getter
    private val name: String? = null
    private val password: String? = null
}