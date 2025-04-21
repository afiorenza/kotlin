package com.server.database

import com.server.database.schemas.ActorsSchema
import com.server.database.schemas.CustomersSchema
import com.server.database.schemas.FilmsSchema
import io.github.cdimascio.dotenv.dotenv
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction


class Connection {
    companion object {
        fun connect() {
            val dotenv = dotenv()

            val dbUrl =
                dotenv["POSTGRES_CONNECTION"] ?: throw IllegalStateException("POSTGRES_CONNECTION not found in .env")
            val dbUser = dotenv["POSTGRES_USER"] ?: throw IllegalStateException("POSTGRES_USER not found in .env")
            val dbPassword =
                dotenv["POSTGRES_PASSWORD"] ?: throw IllegalStateException("POSTGRES_PASSWORD not found in .env")

            Database.connect(
                dbUrl,
                driver = "org.postgresql.Driver",
                user = dbUser,
                password = dbPassword
            )

            transaction {
                SchemaUtils.create(ActorsSchema, CustomersSchema, FilmsSchema)
            }
        }
    }
}