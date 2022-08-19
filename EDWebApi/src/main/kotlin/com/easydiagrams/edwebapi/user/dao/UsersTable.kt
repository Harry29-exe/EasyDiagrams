package com.easydiagrams.edwebapi.user.dao

import org.jetbrains.exposed.dao.id.IntIdTable

object UsersTable : IntIdTable(name = "users") {
    val name = varchar("name", 50).index()
    val uuid = uuid("uuid")
}