package com.easydiagrams.edwebapi.config

import com.easydiagrams.edwebapi.user.dao.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.context.annotation.Configuration

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
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(Users)
        }
    }

}