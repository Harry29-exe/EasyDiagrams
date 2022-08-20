package com.easydiagrams.edwebapi.shared

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.statements.UpdateStatement

abstract class BaseDaoService<ID : Comparable<ID>, DOMAIN : Domain<ID>, TABLE : IdTable<ID>>(
    protected val table: TABLE
) : DaoService<ID, DOMAIN>{

    override fun get(id: ID): DOMAIN? {
        val row = table.select {
            table.id eq id
        }.firstOrNull()

        return if (row != null) domainFromRow(row) else null

    }

    override fun getAll(): List<DOMAIN> {
        return table.selectAll().map { row -> domainFromRow(row) }
    }

    override fun create(domain: DOMAIN): ID {
        return table.insertAndGetId {
            initInsert(it, domain)
        }.value
    }

    override fun update(domain: DOMAIN): Boolean {
        return table.update({
            table.id eq domain.id
        }) {
            initUpdate(it, domain)
        } == 1
    }

    override fun delete(id: ID): Boolean {
        return table.deleteWhere {
            table.id eq id
        } == 1
    }

    protected abstract fun domainFromRow(row: ResultRow): DOMAIN

    protected abstract fun TABLE.initInsert(statement: InsertStatement<EntityID<ID>>, domain: DOMAIN)

    protected abstract fun TABLE.initUpdate(statement: UpdateStatement, domain: DOMAIN)

}