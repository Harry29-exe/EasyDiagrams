package com.easydiagrams.edwebapi.user.api


import com.easydiagrams.edwebapi.generated.api.UserApi
import com.easydiagrams.edwebapi.generated.model.UserDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class UserController : UserApi {

    override fun getAll(): ResponseEntity<List<UserDTO>> {
        return ResponseEntity.ok(listOf( UserDTO("Bob", UUID.randomUUID()) ))
    }

    override fun usersIdGet(id: Int): ResponseEntity<UserDTO> {
        return super.usersIdGet(id)
    }
}