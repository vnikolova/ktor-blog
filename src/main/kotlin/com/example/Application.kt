package com.example

import com.example.dao.*
import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
        // ...
    }.start(wait = true)
    //io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    DatabaseFactory.init(environment.config)
    configureTemplating()
    configureRouting()
}
