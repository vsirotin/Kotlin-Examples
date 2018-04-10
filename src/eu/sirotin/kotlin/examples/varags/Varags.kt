package eu.sirotin.kotlin.examples.varags

fun main(args: Array<String>) {
    val intNumbers = arrayOf(3, 14, 15, 92, 7)
    val lstInts = listOf(1, 2, 12, *intNumbers)
    println("lstInts=" + lstInts)
}