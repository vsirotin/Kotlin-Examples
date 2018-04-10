package eu.sirotin.kotlin.examples.strings.formatter

fun main(args: Array<String>){
    val intNumbers = setOf(3,14,15,92,7)

    println("Formatted ints 1: " + intNumbers.formatToString())
    println("Formatted ints 2: " + intNumbers.formatToString( prefix = "{", separator = ", ", postfix = "}"))

    val strings = listOf("One", "Two", "Seven")
    println("Formatted strings 1: " + strings.formatToString())
}

