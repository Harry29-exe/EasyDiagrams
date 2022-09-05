package com.easydiagrams.edwebapi.config

import com.easydiagrams.edwebapi.user.dao.UsersTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class DBConfig {

    init {
        println("Connecting to db")
        Database.connect(
            url = "jdbc:postgresql://localhost:5432/postgres",
            driver = "org.postgresql.Driver",
            user = "postgres",
            password = "123"
        )
        println("DB connected")

        transaction {
            SchemaUtils.drop(UsersTable)
            SchemaUtils.create(UsersTable)
            UsersTable.insert {
                it[name] = "bob"
                it[passwordHash] = PasswordEncoderProvider.provide().encode("123")
                it[uuid] = UUID.randomUUID()
            }
        }
    }

}