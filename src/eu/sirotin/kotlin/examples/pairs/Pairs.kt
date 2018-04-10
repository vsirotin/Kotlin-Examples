package eu.sirotin.kotlin.examples.pairs

fun main(args: Array<String>) {
    val map = mapOf(1 to "raz", 2 to "dva", 10 to "desat")
    println("map=" + map)

    val(number, name) = 1 to "eins"
    println("number=$number name=$name")
}