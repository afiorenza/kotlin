package com.server

import com.server.controllers.UsersController
import io.javalin.Javalin

fun main(args: Array<String>) {
    val usersController = UsersController()

    val app = Javalin.create {
        it.router.apiBuilder {
            usersController.routes()
        }
    }
        .start(7070)

    app.error(404) { ctx ->
        ctx.result("Not found").status(404)
    }

    app.get("/") { ctx -> ctx.result("Running Kotlin!") }
}