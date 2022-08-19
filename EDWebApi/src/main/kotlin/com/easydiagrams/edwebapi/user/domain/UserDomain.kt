package com.easydiagrams.edwebapi.user.domain

import java.util.UUID

data class UserDomain(
    val id: Int,
    val name: String,
    val uuid: UUID
) {
}