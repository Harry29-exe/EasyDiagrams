package com.easydiagrams.edwebapi.config

import com.easydiagrams.edwebapi.shared.Provider
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

object PasswordEncoderProvider : Provider<PasswordEncoder> {
    private val passwordEncoder = BCryptPasswordEncoder(12)

    override fun provide(): PasswordEncoder {
        return passwordEncoder
    }

    override fun provide(name: String): PasswordEncoder {
        return passwordEncoder
    }

}