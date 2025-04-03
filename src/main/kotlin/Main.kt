import io.javalin.Javalin

fun main() {
    val app = Javalin.create(/*config*/)
//        .get("/") { ctx -> ctx.result("Hello World") }
        .get("/hola") { ctx -> ctx.result("Holaa")}
        .start(7070)
}