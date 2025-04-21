package com.server

import com.server.controllers.UsersController
import com.server.database.Connection
import io.github.cdimascio.dotenv.dotenv
import io.javalin.Javalin

fun main(args: Array<String>) {
    (Connection::connect)()

    val dotenv = dotenv()

    val port = dotenv["SERVER_PORT"] ?: throw IllegalStateException("SERVER_PORT not found in .env")

    val app = Javalin.create {
        it.router.apiBuilder {
            (UsersController::routes)()
        }
    }
        .start(port.toInt())

    app.error(404) { ctx ->
        ctx.result("Not found").status(404)
    }

    app.get("/") { ctx -> ctx.result("Running Kotlin!") }
}