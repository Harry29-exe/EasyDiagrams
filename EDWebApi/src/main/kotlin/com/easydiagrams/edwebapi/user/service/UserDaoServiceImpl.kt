package com.easydiagrams.edwebapi.user.service

import com.easydiagrams.edwebapi.user.dao.UserEntity
import com.easydiagrams.edwebapi.user.dao.UsersTable
import com.easydiagrams.edwebapi.user.domain.UserDomain
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import java.util.*

class UserDaoServiceImpl : UserDaoService {

    override fun getByUUID(uuid: UUID): UserDomain? {
        val row = UsersTable.select {
            UsersTable.uuid eq uuid
        }.firstOrNull()

        return domainFromRow(row)
    }

    override fun get(id: Int): UserDomain? {
        val row = UsersTable.select {
            UsersTable.id eq id
        }.firstOrNull() ?: return null;

        return domainFromRow(row)
    }

    override fun getAll(): List<UserDomain> {
        return UserEntity.all().map { it.domain() }
    }

    override fun create(domain: UserDomain): Int? {
        return UserEntity.new {
            name = domain.name
            uuid = domain.uuid
        }.id.value
    }

    override fun update(domain: UserDomain): Boolean {

    }

    override fun delete(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    private fun domainFromRow(row: ResultRow?): UserDomain? {
        if (row == null) return null

        return UserDomain(
            row[UsersTable.id].value,
            row[UsersTable.name],
            row[UsersTable.uuid]
        )
    }

}