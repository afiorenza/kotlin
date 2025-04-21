package com.server.database.schemas

import org.jetbrains.exposed.dao.id.IntIdTable

object CustomersSchema : IntIdTable("customers") {
    val name = varchar("name", 128)
    val lastName = varchar("description", 128)
    val favourites = reference("favourites", FilmsSchema)
}
