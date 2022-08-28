package com.easydiagrams.edwebapi.user.dao

import org.jetbrains.exposed.dao.id.IntIdTable

object UsersTable : IntIdTable(name = "users") {
    val name = varchar("name", 50).index()
    val passwordHash = varchar("password", 80)
    val uuid = uuid("uuid")
}