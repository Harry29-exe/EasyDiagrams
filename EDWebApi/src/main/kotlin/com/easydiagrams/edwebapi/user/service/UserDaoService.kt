package com.easydiagrams.edwebapi.user.service

import com.easydiagrams.edwebapi.shared.DaoService
import com.easydiagrams.edwebapi.shared.Provider
import com.easydiagrams.edwebapi.user.domain.UserDomain
import java.util.UUID

interface UserDaoService : DaoService<Int, UserDomain> {

    companion object : Provider<UserDaoService> {
        private val instance = UserDaoServiceImpl()
        override fun provide(): UserDaoService {
            return instance
        }

        override fun provide(name: String): UserDaoService {
            return instance
        }
    }

    fun getByUUID(uuid: UUID): UserDomain?

}