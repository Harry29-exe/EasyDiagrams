package com.easydiagrams.edwebapi.user.service

import com.easydiagrams.edwebapi.user.dao.UsersTable
import com.easydiagrams.edwebapi.user.domain.UserDomain
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.statements.UpdateStatement
import java.util.*

class UserDaoServiceImpl : UserDaoService {

    override fun getByUUID(uuid: UUID): UserDomain? {
        val row = UsersTable.select {
            UsersTable.uuid eq uuid
        }.firstOrNull()

        return if (row != null) domainFromRow(row) else null
    }

    override fun get(id: Int): UserDomain? {
        val row = UsersTable.select {
            UsersTable.id eq id
        }.firstOrNull() ?: return null;

        return domainFromRow(row)
    }

    override fun getAll(): List<UserDomain> {
        return UsersTable.selectAll().map { row -> domainFromRow(row) }
    }

    override fun create(domain: UserDomain): Int {
        return UsersTable.insertAndGetId {
            initInsert(it, domain)
        }.value
    }

    override fun update(domain: UserDomain): Boolean {
        return UsersTable.update({
            UsersTable.id eq domain.id
        }) {
            initUpdate(it, domain)
        } == 1
    }

    override fun delete(id: Int): Boolean {
        return UsersTable.deleteWhere { UsersTable.id eq id } == 1
    }

    private fun domainFromRow(row: ResultRow): UserDomain {
        return UserDomain(
            row[UsersTable.id].value,
            row[UsersTable.name],
            row[UsersTable.uuid]
        )
    }

    private fun UsersTable.initInsert(insertStatement: InsertStatement<EntityID<Int>>, domain: UserDomain) {
        insertStatement[name] = domain.name
    }

    private fun UsersTable.initUpdate(updateStatement: UpdateStatement, domain: UserDomain) {
        updateStatement[name] = domain.name
    }

}