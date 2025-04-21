package com.server.controllers

import com.server.entities.User
import com.server.repositories.UsersRepository
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.http.NotFoundResponse
import io.javalin.http.bodyAsClass

class UsersController {
    val userRepository = UsersRepository()

    fun routes() {
        path("users") {
            get { ctx -> ctx.json(userRepository.readAll()) }

            get("{id}") { ctx ->
                val id = ctx.pathParam("id")
                val user = userRepository.readOne(id) ?: throw NotFoundResponse()

                ctx.json(user)
            }

            post { ctx ->
                val user = ctx.bodyAsClass<User>()

                userRepository.create(user)

                ctx.json(user).status(201)
            }

            patch("{id}") { ctx ->
                val id = ctx.pathParam("id")
                val user = ctx.bodyAsClass<User>()

                val updatedUser = userRepository.update(id, user)

                ctx.json(updatedUser).status(204)
            }

            delete("{id}") { ctx ->
                val id = ctx.pathParam("id")

                userRepository.remove(id)

                ctx.status(200)
            }
        }
    }
}