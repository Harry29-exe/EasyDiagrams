package com.easydiagrams.edwebapi.user.api


import com.easydiagrams.edwebapi.config.PasswordEncoderProvider
import com.easydiagrams.edwebapi.generated.api.UserApi
import com.easydiagrams.edwebapi.generated.model.CreateUserDTO
import com.easydiagrams.edwebapi.generated.model.UserDTO
import com.easydiagrams.edwebapi.user.domain.UserDomain
import com.easydiagrams.edwebapi.user.service.UserDaoService
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class UserController : UserApi {
    private val userDaoService = UserDaoService.provide()
    private val passwordEncoder = PasswordEncoderProvider.provide()

    override fun create(createUserDTO: CreateUserDTO): ResponseEntity<Unit> {
        userDaoService.create(UserDomain(
            createUserDTO.name,
            createUserDTO.password,
            passwordEncoder
        ))

        return ResponseEntity.ok().build()
    }

    override fun delete(uuid: UUID): ResponseEntity<Unit> {
        return super.delete(uuid)
    }

    override fun get(uuid: UUID): ResponseEntity<UserDTO> {
        return super.get(uuid)
    }

    override fun getAll(): ResponseEntity<List<UserDTO>> {
        return super.getAll()
    }



}