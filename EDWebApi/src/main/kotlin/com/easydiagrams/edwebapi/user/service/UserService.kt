package com.easydiagrams.edwebapi.user.service

import com.easydiagrams.edwebapi.generated.model.UserDTO
import com.easydiagrams.edwebapi.shared.Provider

interface UserService {

    companion object : Provider<UserService> {
        override fun provide(): UserService {
            TODO("Not yet implemented")
        }

        override fun provide(name: String): UserService {
            TODO("Not yet implemented")
        }
    }

    fun get(id: Int): UserDTO?

    fun getAll(): List<UserDTO>

}