package eu.sirotin.kotlin.examples.interfaces

open class Responder : Respondable, Closeable {
    final override fun respond() {
        println("I am respond in Responder and I was called!")
    }

    override fun close() {
        println("I am close in Responder and I was called!")
    }
}