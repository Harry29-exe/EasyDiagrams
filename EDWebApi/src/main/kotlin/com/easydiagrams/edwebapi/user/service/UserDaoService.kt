package com.easydiagrams.edwebapi.user.service

import com.easydiagrams.edwebapi.shared.DaoService
import com.easydiagrams.edwebapi.user.domain.UserDomain
import java.util.UUID

interface UserDaoService : DaoService<Int, UserDomain> {

    fun getByUUID(uuid: UUID): UserDomain?

}