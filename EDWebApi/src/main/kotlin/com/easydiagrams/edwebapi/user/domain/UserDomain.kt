package com.easydiagrams.edwebapi.user.domain

import com.easydiagrams.edwebapi.shared.Domain
import java.util.UUID

data class UserDomain (
    override val id: Int,
    val name: String,
    val uuid: UUID
)  : Domain<Int> {

}