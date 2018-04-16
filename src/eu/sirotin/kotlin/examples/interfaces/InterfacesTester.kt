package eu.sirotin.kotlin.examples.interfaces

fun main(args: Array<String>) {
    val responder = Responder()
    println(responder.respond())
    println(responder.close())
}