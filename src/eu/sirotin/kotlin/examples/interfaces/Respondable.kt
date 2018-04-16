package eu.sirotin.kotlin.examples.interfaces

interface Respondable {
    fun respond()
    fun close() = println("I am Respondable and I am closed!")
}