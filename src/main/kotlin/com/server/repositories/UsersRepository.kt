package com.server.repositories

import com.server.entities.User
import io.javalin.http.NotFoundResponse
import io.javalin.http.NotModifiedResponse

class UsersRepository {
    companion object {
        val users = hashSetOf<User>()
    }

    fun readAll(): HashSet<User> {
        return users
    }

    fun readOne(id: String): User? {
        return users.find {
            it.id == id
        }
    }

    fun create(user: User) {
        users.add(user)
    }

    fun update(id: String, user: User): User {
        val userToUpdate = readOne(id)

        if (userToUpdate == null) {
            throw NotModifiedResponse()
        }

        users.remove(userToUpdate)
        users.add(user)

        return user
    }

    fun remove(id: String) {
        val removed = users.removeIf { it.id == id }

        if (!removed) {
            throw NotFoundResponse()
        }
    }
}