package com.easydiagrams.edwebapi.user.api


import com.easydiagrams.edwebapi.generated.api.UserApi
import com.easydiagrams.edwebapi.generated.model.UserDTO
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController : UserApi {

    override fun getAll(): ResponseEntity<List<UserDTO>> = transaction {
        addLogger(StdOutSqlLogger)
        ResponseEntity.ok(
            UserEntity.all().map { u -> u.dto() }.toList()
        )
    }

    override fun usersIdGet(id: Int): ResponseEntity<UserDTO> {
        return super.usersIdGet(id)
    }
}