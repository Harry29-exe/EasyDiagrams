package com.easydiagrams.edwebapi.user.service

import com.easydiagrams.edwebapi.shared.BaseDaoService
import com.easydiagrams.edwebapi.user.dao.UsersTable
import com.easydiagrams.edwebapi.user.domain.UserDomain
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.statements.UpdateStatement
import java.util.*

class UserDaoServiceImpl : BaseDaoService<Int, UserDomain, UsersTable>(UsersTable), UserDaoService {

    override fun getByUUID(uuid: UUID): UserDomain? {
        val row = table.select {
            table.uuid eq uuid
        }.firstOrNull()

        return if (row != null) domainFromRow(row) else null
    }

    override fun domainFromRow(row: ResultRow): UserDomain {
        return UserDomain(
            row[UsersTable.id].value,
            row[UsersTable.name],
            row[UsersTable.passwordHash],
            row[UsersTable.uuid]
        )
    }

    override fun UsersTable.initInsert(statement: InsertStatement<EntityID<Int>>, domain: UserDomain) {
        statement[name] = domain.name
    }

    override fun UsersTable.initUpdate(statement: UpdateStatement, domain: UserDomain) {
        statement[name] = domain.name
    }

}