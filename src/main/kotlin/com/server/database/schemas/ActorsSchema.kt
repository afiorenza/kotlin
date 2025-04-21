package com.server.database.schemas

import org.jetbrains.exposed.dao.id.IntIdTable

object ActorsSchema : IntIdTable("actors") {
    val name = varchar("name", 128)
    val lastName = varchar("description", 128)
}
