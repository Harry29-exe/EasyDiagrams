package com.easydiagrams.edwebapi.user.dao

import com.easydiagrams.edwebapi.generated.model.UserDTO
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(UsersTable)

    var name by UsersTable.name
    val uuid by UsersTable.uuid

    fun mapToDTO(): UserDTO {
        return UserDTO(name, uuid)
    }

}