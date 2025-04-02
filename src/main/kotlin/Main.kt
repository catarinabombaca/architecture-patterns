package org.example

import org.http4k.client.ApacheClient
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.server.Undertow
import org.http4k.server.asServer

fun main() {
    val app = { request: Request -> Response(OK).body("Hello!") }

    val server = app.asServer(Undertow(9000)).start()

    val client = ApacheClient()

    val request = Request(Method.GET, "http://localhost:9000")

    println(client(request))

    server.stop()
}