package com.server.database.schemas

import org.jetbrains.exposed.dao.id.IntIdTable

object FilmsSchema : IntIdTable("films") {
    val name = varchar("name", 128)
    val actors = reference("actors", ActorsSchema)
}
