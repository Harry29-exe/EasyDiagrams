package com.easydiagrams.edwebapi.user.domain

import com.easydiagrams.edwebapi.generated.model.UserDTO
import com.easydiagrams.edwebapi.shared.Domain
import com.easydiagrams.edwebapi.shared.DtoMappable
import org.springframework.security.crypto.password.PasswordEncoder
import java.util.UUID

data class UserDomain (
    override val id: Int,
    var name: String,
    var passwordHash: String,
    val uuid: UUID
)  : Domain<Int>, DtoMappable<UserDTO> {

    constructor(name: String, password: String, passwordHasher: PasswordEncoder) : this(
        0,
        name,
        passwordHasher.encode(password),
        UUID.randomUUID()
    ) {

    }

    override fun dto(): UserDTO {
        return UserDTO(
            name,
            uuid
        )
    }
}