package com.easydiagrams.edwebapi.user.domain

import com.easydiagrams.edwebapi.generated.model.UserDTO
import com.easydiagrams.edwebapi.shared.Domain
import com.easydiagrams.edwebapi.shared.DtoMappable
import org.springframework.security.crypto.password.PasswordEncoder
import java.util.UUID

class UserDomain : Domain<Int>, DtoMappable<UserDTO> {

    constructor(
        id: Int,
        username: String,
        name: String,
        password: String,
        passwordHasher: PasswordEncoder,
        roles: MutableSet<RoleDomain> = mutableSetOf(RoleDomain.USER)
    ) {
        this.id = id
        this.username = username
        this.name = name
        this.passwordHash = passwordHasher.encode(password)
        this.roles = roles
    }

    override val id: Int
    val username: String
    var name: String
        private set
    var passwordHash: String
        private set
    val uuid: UUID = UUID.randomUUID()
    private val roles: MutableSet<RoleDomain>

    fun hasRole(role: RoleDomain): Boolean {
        return roles.contains(role)
    }

    fun updatePassword(password: String, passwordHasher: PasswordEncoder) {
        passwordHash = passwordHasher.encode(password)
    }

    override fun dto(): UserDTO {
        return UserDTO(
            name,
            uuid
        )
    }
}