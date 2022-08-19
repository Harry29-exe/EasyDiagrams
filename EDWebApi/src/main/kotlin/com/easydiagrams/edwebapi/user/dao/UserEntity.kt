package com.easydiagrams.edwebapi.user.dao

import com.easydiagrams.edwebapi.generated.model.UserDTO
import com.easydiagrams.edwebapi.user.domain.UserDomain
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UserEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserEntity>(UsersTable)

    var name by UsersTable.name
    var uuid by UsersTable.uuid

    fun domain(): UserDomain {
        return UserDomain(id.value, name, uuid)
    }

}