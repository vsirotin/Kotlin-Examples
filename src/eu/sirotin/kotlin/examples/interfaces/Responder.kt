package eu.sirotin.kotlin.examples.interfaces

class Responder : Respondable, Closeable {
    override fun respond() {
        println("I am Responder and I was called!")
    }

    override fun close() {
        super.close()
    }
}