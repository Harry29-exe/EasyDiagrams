package com.easydiagrams.edwebapi.user.dao

import org.jetbrains.exposed.dao.id.IntIdTable

object UsersTable : IntIdTable() {
    val name = varchar("name", 50).index()
    val uuid = uuid("uuid")
}